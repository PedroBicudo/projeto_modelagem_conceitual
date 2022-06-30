package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Phone;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.PhonePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, PhonePK> {

}
