package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;

public interface ICategoryService {
    Category findById(Integer id);
}
