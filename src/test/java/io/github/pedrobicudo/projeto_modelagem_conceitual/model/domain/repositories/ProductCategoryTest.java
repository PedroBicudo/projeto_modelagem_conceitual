package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductCategoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager manager;

    @Test
    @Sql("/create-categories-and-products.sql")
    @DisplayName("test add products to category")
    public void testAddProductsToCategory() {
        // Given
        List<Product> products = productRepository.findAll();
        assertEquals(2, products.size());

        Optional<Category> categoryOpt = categoryRepository.findById(1);
        assertThat(categoryOpt).isPresent();

        // When
        Category category = categoryOpt.get();
        category.getProducts().addAll(products);
        categoryRepository.save(category);

        // Then
        categoryOpt = categoryRepository.findById(1);
        assertThat(categoryOpt).isPresent();
        category = categoryOpt.get();
        assertEquals(category.getProducts().size(), 2);
    }

    @Test
    @Sql("/create-categories-and-products.sql")
    @DisplayName("test add category to products")
    public void testAddCategoryToProducts() {
        // Given
        List<Product> products = productRepository.findAll();
        assertEquals(2, products.size());
        Optional<Category> categoryOpt = categoryRepository.findById(1);
        assertThat(categoryOpt).isPresent();
        Category category = categoryOpt.get();

        // When
        products.get(0).getCategories().add(category);
        products.forEach(manager::persist);
        products = productRepository.findAll();

        // Then
        assertEquals(1, products.get(0).getCategories().size());
        assertEquals(0, products.get(1).getCategories().size());

    }

}
