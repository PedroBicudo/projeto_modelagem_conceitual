package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    @DisplayName("name must be not null")
    public void testNameMustBeNotNull() {
        Product product = new Product(null,null, BigDecimal.valueOf(2000.0));

        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(product);
        });

    }

    @Test
    @DisplayName("name must be less than or equal to 64")
    public void testNameMustBeLessThanOrEqualTo64() {
        Product product = new Product(
                null,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", // 65
                BigDecimal.valueOf(2000.0));

        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(product);
        });

    }

    @Test
    @DisplayName("price must be not null")
    public void testPriceMustBeNotNull() {
        Product product = new Product(null,"foo", null);

        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(product);
        });

    }

    @Test
    @DisplayName("price must have precision 10 and scale 2")
    public void testPriceMustHavePrecision10AndScale2() {
        Product incorrect = new Product(
                null,
                "foo",
                new BigDecimal("100000000.00") // 9,2 = 11
        );

        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(incorrect);
        });

    }

}