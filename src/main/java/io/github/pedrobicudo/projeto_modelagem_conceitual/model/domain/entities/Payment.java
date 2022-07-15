package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums.PaymentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @JsonIgnore
    @Column(name = "STATE", nullable = false)
    private Integer state;

    @JsonIgnore
    @MapsId
    @OneToOne
    @JoinColumn(name = "IDFK_PAYMENT_ORDER")
    private Order order;

    public Payment(Integer id, PaymentState paymentState) {
        this.id = id;
        this.state = paymentState.getCode();
    }

    @JsonProperty("state")
    public PaymentState getState() {
        return PaymentState.toEnum(state);
    }
}
