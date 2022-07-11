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

import java.util.Date;

@DataJpaTest
class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("payment must be created successfully")
    @Sql("/create-clients-with-addresses.sql")
    public void testPaymentMustBeCreatedSuccessfully() {
        Client client = clientRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Order order = new Order(null, new Date(), null, client.getAddresses().get(0), client);

        Payment payment = new PaymentWithCard(null, PaymentState.PENDING.getCode(), order, 1);
        order.setPayment(payment);

        entityManager.persist(order);
        entityManager.persist(payment);

    }

}