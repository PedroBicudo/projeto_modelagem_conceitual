package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "PRODUCT_CATEGORY",
            joinColumns = {
                    @JoinColumn(name = "IDFK_PRODUCT_PRODUCT_CATEGORY")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "IDFK_CATEGORY_PRODUCT_CATEGORY")
            }
    )
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "pk.product")
    private List<OrderItem> items = new ArrayList<>();

    public Product(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public List<Order> getOrders() {
        return items.stream()
                .map(item -> item.getPk().getOrder())
                .collect(Collectors.toList());
    }
}
