package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PhonePK implements Serializable{

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IDFK_CLIENT_PHONE")
    private Client owner;

    @Column(name = "NUMBER", nullable = false)
    private String number;

}
