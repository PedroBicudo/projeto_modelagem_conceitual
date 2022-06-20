package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.PersistenceException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("name must be less than or equal to 24 characters")
    public void testNameMustBeLessThanOrEqualTo24Characters() {
        Category category = new Category(
                null,
                "aaaaaaaaaaaaaaaaaaaaaaaaa"
        );
        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(category);
        });
    }

    @Test
    @DisplayName("name must be not null")
    public void testNameMustBeNotNull() {
        Category category = new Category(
                null,
                null
        );
        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(category);
        });
    }


}