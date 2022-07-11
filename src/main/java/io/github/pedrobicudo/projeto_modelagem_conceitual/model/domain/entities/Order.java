package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

}
