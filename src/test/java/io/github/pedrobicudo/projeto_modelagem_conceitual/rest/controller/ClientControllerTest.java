package io.github.pedrobicudo.projeto_modelagem_conceitual.rest.controller;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Category;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Client;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.exceptions.ObjectNotFoundException;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.*;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces.IClientService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
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

@WebMvcTest(controllers = {ClientController.class})
class ClientControllerTest {

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
    private StateRepository stateRepository;

    @MockBean
    private CityRepository cityRepository;

    @MockBean
    private IClientService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/clients/{id} endpoint should exist")
    public void testCategoriesIdShouldExist() throws Exception {
        Mockito.when(service.findById(1)).thenReturn(new Client());

        mockMvc.perform(MockMvcRequestBuilders.get("/clients/1"))
                .andExpect(status().isFound());
    }

    @Test
    @DisplayName("/clients/{id} with non existent id must return not found status code")
    public void testCategoriesIdWithNonExistentIdMustReturnNotFoundStatusCode() throws Exception {
        Mockito.when(service.findById(1))
                .thenThrow(ObjectNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/clients/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.statusCode").value(404));
    }

}