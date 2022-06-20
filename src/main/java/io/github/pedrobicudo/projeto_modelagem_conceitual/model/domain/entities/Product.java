package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 64)
    private String name;

    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}
