package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PHONE")
public class Phone {

    @EmbeddedId
    private PhonePK pk;

}
