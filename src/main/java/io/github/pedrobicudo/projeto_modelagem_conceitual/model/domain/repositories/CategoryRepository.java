package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
