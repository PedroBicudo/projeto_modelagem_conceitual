package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Client;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums.ClientType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.PersistenceException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("name must not be null")
    public void testNameMustNotBeNull() {
        Client client = new Client(null, null, "a@gmail.com", "12312312312", ClientType.NATURAL_PERSON);
        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(client);
        });
    }

    @Test
    @DisplayName("email must not be null")
    public void testEmailMustNotBeNull() {
        Client client = new Client(null, "foo", null, "12312312312", ClientType.NATURAL_PERSON);
        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(client);
        });
    }

    @Test
    @DisplayName("cpfOrCnpj must not be null")
    public void testCpfOrCnpjMustNotBeNull() {
        Client client = new Client(null, "foo", "a@gmail.com", null, ClientType.NATURAL_PERSON);
        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(client);
        });
    }

}