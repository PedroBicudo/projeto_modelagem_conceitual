package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Client;

public interface IClientService {
    Client findById(Integer id);
}
