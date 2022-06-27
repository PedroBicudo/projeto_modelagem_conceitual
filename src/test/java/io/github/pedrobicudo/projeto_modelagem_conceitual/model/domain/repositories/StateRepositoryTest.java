package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

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
class StateRepositoryTest {

    @Autowired
    private StateRepository repository;

    @Autowired
    private TestEntityManager manager;

    @Test
    @DisplayName("create state name must not be null")
    public void testStateNameMustNotBeNull() {
        State state = new State(null, null);

        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(state);
        });
    }

    @Test
    @DisplayName("create state name must have size less than or equal to 100")
    public void testStateNameMustHaveSizeLessThanOrEqualTo100() {
        State state = new State(
                null,
                // 101 characters
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        );

        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(state);
        });
    }

}