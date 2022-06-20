package io.github.pedrobicudo.projeto_modelagem_conceitual;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjetoModelagemConceitualApplication implements CommandLineRunner {

	@Value("${spring.profiles.active}")
	private String profiles;

	@Autowired
	private CategoryRepository repository;

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

		repository.saveAll(categories);

	}
}
