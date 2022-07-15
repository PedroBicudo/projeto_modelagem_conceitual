package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "ADDITION")
    private String addition;

    @Column(name = "AREA", nullable = false)
    private String area;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IDFK_CLIENT_ADDRESS")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "IDFK_CITY_ADDRESS")
    private City city;


}
