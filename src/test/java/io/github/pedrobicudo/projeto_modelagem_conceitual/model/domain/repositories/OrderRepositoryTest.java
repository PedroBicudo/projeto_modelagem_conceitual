package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Client;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Order;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Payment;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.PaymentWithCard;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums.PaymentState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.PersistenceException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("instant must not be null")
    public void testInstantMustNotBeNull() {
        Order order = new Order(null, null, null, null, null);

        assertThrows(PersistenceException.class, () -> {
            entityManager.persistAndFlush(order);
        });
    }

    @Test
    @DisplayName("create order must be created successfully")
    @Sql("/create-clients-with-addresses.sql")
    public void testCreateOrderMustBeCreatedSuccessfully() {
        Client client = clientRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Order order = new Order(null, new Date(), null, client.getAddresses().get(0), client);

        Payment payment = new PaymentWithCard(null, PaymentState.PENDING.getCode(), order, 1);
        payment.setOrder(order);

        entityManager.persist(order);
        entityManager.persist(payment);
        order.setPayment(payment);

        entityManager.persist(order);

    }

}