package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "IDFK_PRODUCT_ORDER_ITEM")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "IDFK_ORDER_ORDER_ITEM")
    private Order order;
}
