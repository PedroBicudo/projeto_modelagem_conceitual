package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "INSTANT", nullable = false)
    private Date instant;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "IDFK_ADDRESS_ORDER")
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "IDFK_CLIENT_ORDER")
    private Client client;

    @OneToMany(mappedBy = "pk.order")
    private List<OrderItem> items = new ArrayList<>();

    public Order(Integer id, Date instant, Payment payment, Address deliveryAddress, Client client) {
        this.id = id;
        this.instant = instant;
        this.payment = payment;
        this.deliveryAddress = deliveryAddress;
        this.client = client;
    }
}
