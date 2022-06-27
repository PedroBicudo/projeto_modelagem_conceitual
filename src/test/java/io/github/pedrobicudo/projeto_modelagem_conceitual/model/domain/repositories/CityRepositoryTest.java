package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.City;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.City;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.PersistenceException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CityRepositoryTest {

    @Autowired
    private CityRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    @DisplayName("create city name must not be null")
    public void testCityNameMustNotBeNull() {
        State state = new State(null, "A");
        manager.persist(state);

        City city = new City(null, null, state);

        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(city);
        });
    }

    @Test
    @DisplayName("create city name must have size less than or equal to 100")
    public void testCityNameMustHaveSizeLessThanOrEqualTo100() {
        State state = new State(null, "A");
        manager.persist(state);

        City city = new City(
                null,
                // 101 characters
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                state
        );

        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(city);
        });
    }

}