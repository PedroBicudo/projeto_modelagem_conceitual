package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Order;

public interface IOrderService {
    Order findById(Integer id);
}
