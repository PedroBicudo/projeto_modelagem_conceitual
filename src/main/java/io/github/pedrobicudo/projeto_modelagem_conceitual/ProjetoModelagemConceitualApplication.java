package io.github.pedrobicudo.projeto_modelagem_conceitual;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.*;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums.ClientType;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums.PaymentState;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjetoModelagemConceitualApplication implements CommandLineRunner {

	@Value("${spring.profiles.active}")
	private String profiles;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PhoneRepository phoneRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public static void main(String[] args) {
		SpringApplication.run(ProjetoModelagemConceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!profiles.equals("dev")) return;

		List<Category> categories = List.of(
			new Category(null, "Informática"),
			new Category(null, "Escritório")
		);

		List<Product> products = List.of(
			new Product(null, "computador", BigDecimal.valueOf(2000.00)),
			new Product(null, "impressora", BigDecimal.valueOf(800.00)),
			new Product(null, "mouse", BigDecimal.valueOf(80.00))
		);

		categories.get(0)
				.getProducts()
				.addAll(List.of(products.get(0), products.get(1)));

		products.get(0)
				.getCategories().add(categories.get(0));

		products.get(1)
				.getCategories().add(categories.get(0));

		categories.get(1)
				.getProducts()
				.addAll(List.of(products.get(2)));

		products.get(2)
				.getCategories().add(categories.get(1));

		categoryRepository.saveAll(categories);
		productRepository.saveAll(products);

		// ---
		List<State> states = List.of(
			new State(null,"Minas Gerais", new ArrayList<>()),
			new State(null,"São Paulo", new ArrayList<>())
		);

		List<City> cities = List.of(
			new City(null, "Uberlândia", states.get(0)),
			new City(null, "São Paulo", states.get(1)),
			new City(null, "Campinas", states.get(1))
		);

		states.get(0).getCities()
				.addAll(List.of(cities.get(0)));

		states.get(1).getCities()
				.addAll(List.of(cities.get(1), cities.get(2)));

		stateRepository.saveAll(states);
		cityRepository.saveAll(cities);

		Client client = new Client(null, "foo", "foo@gmail.com", "123456789", ClientType.NATURAL_PERSON);
		clientRepository.save(client);

		List<Phone> phones = List.of(
				new Phone(new PhonePK(client, "27363323")),
				new Phone(new PhonePK(client, "93838393"))
		);
		phoneRepository.saveAll(phones);

		List<Address> addresses = List.of(
				new Address(
						null,
						"Rua flores",
						"300",
						"Apto 203",
						"Jardim",
						"38220834",
						client,
						cities.get(0)
				),
				new Address(
						null,
						"Avenida Matos",
						"105",
						"Sala 800",
						"Centro",
						"38777012",
						client,
						cities.get(1)
				)
		);
		client.getAddresses().addAll(addresses);
		clientRepository.save(client);
		addressRepository.saveAll(addresses);

		// ---
		List<Order> orders = List.of(
				new Order(null, sdf.parse("30/09/2017 10:32"), null, client.getAddresses().get(0), client),
				new Order(null, sdf.parse("10/10/2017 19:35"), null, client.getAddresses().get(1), client)
		);

		List<Payment> payments = List.of(
			new PaymentWithCard(null, PaymentState.ACCEPTED.getCode(), orders.get(0), 6),
			new PaymentWithBill(null, PaymentState.PENDING.getCode(), orders.get(1), sdf.parse("20/10/2017 00:00"), null)
		);

		orders.get(0)
				.setPayment(payments.get(0));

		orders.get(1)
				.setPayment(payments.get(1));

		client.getOrders().addAll(orders);
		orderRepository.saveAll(orders);
		paymentRepository.saveAll(payments);
		clientRepository.save(client);
		// ---
		List<OrderItem> items = List.of(
			new OrderItem(
					new OrderItemPK(products.get(0), orders.get(0)),
					0.00,
					1,
					BigDecimal.valueOf(2000.00)
			),
			new OrderItem(
					new OrderItemPK(products.get(1), orders.get(1)),
					0.00,
					1,
					BigDecimal.valueOf(800.00)
			),
			new OrderItem(
					new OrderItemPK(products.get(2), orders.get(0)),
					0.00,
					2,
					BigDecimal.valueOf(80.00)
			)
		);

		orders.get(0)
				.getItems().addAll(List.of(items.get(0), items.get(2)));

		orders.get(1)
				.getItems().addAll(List.of(items.get(1)));

		orderItemRepository.saveAll(items);
		orderRepository.saveAll(orders);
		// ---



	}
}
