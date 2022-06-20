package io.github.pedrobicudo.projeto_modelagem_conceitual.rest.controller;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces.ICategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {CategoryController.class})
class CategoryControllerTest {

    @MockBean
    private ICategoryService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/categories/{id} endpoint should exist")
    public void testCategoriesIdShouldExist() throws Exception {
        Mockito.when(service.findById(1)).thenReturn(new Category(1, "foo"));

        mockMvc.perform(MockMvcRequestBuilders.get("/categories/1"))
                .andExpect(status().isOk());
    }

}