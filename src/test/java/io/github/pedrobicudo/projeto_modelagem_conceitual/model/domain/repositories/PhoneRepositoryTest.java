package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Client;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Phone;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.PhonePK;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums.ClientType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PhoneRepositoryTest {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("create phone number")
    @Sql("/create-clients.sql")
    public void testCreatePhoneNumber() {
        Client client = clientRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        PhonePK pk = new PhonePK(client, "1234567890");
        Phone phone = new Phone(pk);
        entityManager.persistAndFlush(phone);

        assertThat(phoneRepository.findById(pk)).isPresent();

    }

    @Test
    @DisplayName("phone number must be not null")
    @Sql("/create-clients.sql")
    public void testPhoneNumberMustBeNotNull() {
        Client client = clientRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        PhonePK pk = new PhonePK(client, null);
        Phone phone = new Phone(pk);

        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(phone);
        });

    }

    @Test
    @DisplayName("client must be not null")
    public void testClientNumberMustBeNotNull() {
        PhonePK pk = new PhonePK(null, "1234567890");
        Phone phone = new Phone(pk);

        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(phone);
        });

    }

}