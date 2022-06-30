package io.github.pedrobicudo.projeto_modelagem_conceitual;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.*;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums.ClientType;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
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

	}
}
