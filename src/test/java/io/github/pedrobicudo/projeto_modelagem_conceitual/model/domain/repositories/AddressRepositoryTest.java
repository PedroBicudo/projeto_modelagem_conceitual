package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Address;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.City;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.PersistenceException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TestEntityManager entityManager;

    private City city = null;
    private Client client = null;

    @Test
    @DisplayName("address must be not null")
    @Sql("/create-clients.sql")
    @Sql("/create-states-and-cities.sql")
    public void testAddressMustBeNotNull() {
        city = cityRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        client = clientRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Address address = new Address(
                null,
                null,
                "foo",
                "foo",
                "foo",
                "foo",
                client,
                city
        );

        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(address);
        });
    }

    @Test
    @DisplayName("number must be not null")
    @Sql("/create-clients.sql")
    @Sql("/create-states-and-cities.sql")
    public void testNumberMustBeNotNull() {
        city = cityRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        client = clientRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Address address = new Address(
                null,
                "foo",
                null,
                "foo",
                "foo",
                "foo",
                client,
                city
        );

        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(address);
        });
    }

    @Test
    @DisplayName("area must be not null")
    @Sql("/create-clients.sql")
    @Sql("/create-states-and-cities.sql")
    public void testAreaMustBeNotNull() {
        city = cityRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        client = clientRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Address address = new Address(
                null,
                "foo",
                "foo",
                "foo",
                null,
                "foo",
                client,
                city
        );

        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(address);
        });
    }

    @Test
    @DisplayName("cep must be not null")
    @Sql("/create-clients.sql")
    @Sql("/create-states-and-cities.sql")
    public void testCepMustBeNotNull() {
        city = cityRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        client = clientRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Address address = new Address(
                null,
                null,
                "foo",
                "foo",
                "foo",
                null,
                client,
                city
        );

        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(address);
        });
    }

}