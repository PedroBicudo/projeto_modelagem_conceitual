package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PAYMENT_WITH_BILL")
@Data
@NoArgsConstructor
public class PaymentWithBill extends Payment {

    @Column(name = "DUE_DATE")
    private Date dueDate;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    public PaymentWithBill(Integer id, Integer state, Order order, Date dueDate, Date paymentDate) {
        super(id, state, order);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }
}
