package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "CPF_OR_CNPJ", nullable = false)
    private String cpfOrCnpj;

    @Column(name = "TYPE", nullable = false)
    private Integer type;

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.owner")
    private List<Phone> phones = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Client(Integer id, String name, String email, String cpfOrCnpj, ClientType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.type = type.getCode();
    }

    public ClientType getType() {
        return ClientType.toEnum(this.type);
    }
}
