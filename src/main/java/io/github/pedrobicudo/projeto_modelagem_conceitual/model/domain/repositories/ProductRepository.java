package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
