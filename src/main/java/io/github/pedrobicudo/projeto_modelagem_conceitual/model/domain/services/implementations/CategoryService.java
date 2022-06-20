package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.implementations;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.CategoryRepository;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
