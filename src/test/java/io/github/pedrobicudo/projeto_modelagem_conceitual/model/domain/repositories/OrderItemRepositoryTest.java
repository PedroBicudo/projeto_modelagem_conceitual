package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Order;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.OrderItem;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.OrderItemPK;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderItemRepositoryTest {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager manager;

    @Test
    @Sql("/create-user-orders.sql")
    @DisplayName("disconut must be not null")
    public void testDiscountMustBeNotNull() {
        Product productOne = productRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Product productTwo = productRepository.findById(3)
                .orElseThrow(IllegalStateException::new);

        Order order = orderRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        OrderItemPK orderItemPKOne = new OrderItemPK(productOne, order);
        OrderItemPK orderItemPKTwo = new OrderItemPK(productTwo, order);

        OrderItem orderItemOne = new OrderItem(orderItemPKOne, null, 1, BigDecimal.valueOf(2000.00));
        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(orderItemOne);
        });

        OrderItem orderItemTwo = new OrderItem(orderItemPKTwo, null, 2, BigDecimal.valueOf(80.00));
        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(orderItemTwo);
        });

    }

    @Test
    @Sql("/create-user-orders.sql")
    @DisplayName("quantity must be not null")
    public void testQuantityMustBeNotNull() {
        Product productOne = productRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Product productTwo = productRepository.findById(3)
                .orElseThrow(IllegalStateException::new);

        Order order = orderRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        OrderItemPK orderItemPKOne = new OrderItemPK(productOne, order);
        OrderItemPK orderItemPKTwo = new OrderItemPK(productTwo, order);

        OrderItem orderItemOne = new OrderItem(orderItemPKOne, 0.00, null, BigDecimal.valueOf(2000.00));
        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(orderItemOne);
        });

        OrderItem orderItemTwo = new OrderItem(orderItemPKTwo, 0.00, null, BigDecimal.valueOf(80.00));
        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(orderItemTwo);
        });

    }

    @Test
    @Sql("/create-user-orders.sql")
    @DisplayName("price must be not null")
    public void testPriceMustBeNotNull() {
        Product productOne = productRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        Product productTwo = productRepository.findById(3)
                .orElseThrow(IllegalStateException::new);

        Order order = orderRepository.findById(1)
                .orElseThrow(IllegalStateException::new);

        OrderItemPK orderItemPKOne = new OrderItemPK(productOne, order);
        OrderItemPK orderItemPKTwo = new OrderItemPK(productTwo, order);

        OrderItem orderItemOne = new OrderItem(orderItemPKOne, 0.00, 1, null);
        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(orderItemOne);
        });

        OrderItem orderItemTwo = new OrderItem(orderItemPKTwo, 0.00, 8, null);
        assertThrows(PersistenceException.class, () -> {
            manager.persistAndFlush(orderItemTwo);
        });

    }

}