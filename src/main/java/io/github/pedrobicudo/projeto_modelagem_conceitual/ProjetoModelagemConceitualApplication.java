package io.github.pedrobicudo.projeto_modelagem_conceitual;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Product;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.CategoryRepository;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class ProjetoModelagemConceitualApplication implements CommandLineRunner {

	@Value("${spring.profiles.active}")
	private String profiles;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

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

	}
}
