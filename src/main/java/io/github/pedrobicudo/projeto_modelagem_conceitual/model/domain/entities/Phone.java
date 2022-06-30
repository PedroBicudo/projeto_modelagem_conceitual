package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PHONE")
public class Phone {

    @EmbeddedId
    private PhonePK pk;

    @JsonValue
    public String number() {
        return pk.getNumber();
    }

}
