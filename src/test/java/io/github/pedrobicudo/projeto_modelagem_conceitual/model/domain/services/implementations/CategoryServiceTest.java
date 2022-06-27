package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.implementations;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.exceptions.ObjectNotFoundException;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService service;

    @Test
    @DisplayName("Non existent id must throw ObjectNotFoundException")
    public void testFindByIdCategoryNonExistentIdMustThrowObjectNotFoundException() {
        Mockito.when(categoryRepository.findById(1))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(ObjectNotFoundException.class, () -> {
            service.findById(1);
        });

        assertEquals("Object not found! id: 1, Type: Category", exception.getMessage());

    }

}