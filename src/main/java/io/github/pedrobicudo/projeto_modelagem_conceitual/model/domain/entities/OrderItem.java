package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @JsonIgnore
    @EmbeddedId
    private OrderItemPK pk;

    @Column(name = "DISCOUNT", nullable = false)
    private Double discount;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @JsonProperty("product")
    public Product getProduct() {
        return pk.getProduct();
    }
}
