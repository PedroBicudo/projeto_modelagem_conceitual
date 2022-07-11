package io.github.pedrobicudo.projeto_modelagem_conceitual.rest.controller;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.exceptions.ObjectNotFoundException;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.*;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces.ICategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private ClientRepository clientRepository;

    @MockBean
    private AddressRepository addressRepository;

    @MockBean
    private PhoneRepository phoneRepository;

    @MockBean
    private ICategoryService service;

    @MockBean
    private StateRepository stateRepository;

    @MockBean
    private CityRepository cityRepository;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private PaymentRepository paymentRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/categories/{id} endpoint should exist")
    public void testCategoriesIdShouldExist() throws Exception {
        Mockito.when(service.findById(1)).thenReturn(new Category(1, "foo"));

        mockMvc.perform(MockMvcRequestBuilders.get("/categories/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/categories/{id} with non existent id must return not found status code")
    public void testCategoriesIdWithNonExistentIdMustReturnNotFoundStatusCode() throws Exception {
        Mockito.when(service.findById(1))
                .thenThrow(ObjectNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/categories/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.statusCode").value(404));
    }

}