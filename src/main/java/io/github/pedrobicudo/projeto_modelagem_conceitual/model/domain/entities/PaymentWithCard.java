package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_WITH_CARD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentWithCard extends Payment {

    @Column(name = "TOTAL_INSTALLMENTS")
    private Integer totalInstallments;

    public PaymentWithCard(Integer id, Integer state, Order order, Integer totalInstallments) {
        super(id, state, order);
        this.totalInstallments = totalInstallments;
    }
}
