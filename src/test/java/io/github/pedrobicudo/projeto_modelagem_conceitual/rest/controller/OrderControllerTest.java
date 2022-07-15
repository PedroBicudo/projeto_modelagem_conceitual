package io.github.pedrobicudo.projeto_modelagem_conceitual.rest.controller;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Order;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.exceptions.ObjectNotFoundException;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.*;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces.IOrderService;
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

@WebMvcTest(controllers = {OrderController.class})
class OrderControllerTest {

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
    private OrderRepository orderRepository;

    @MockBean
    private PaymentRepository paymentRepository;

    @MockBean
    private OrderItemRepository orderItemRepository;

    @MockBean
    private IOrderService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/orders/{id} endpoint should exist")
    public void testOrderIdShouldExist() throws Exception {
        Mockito.when(service.findById(Mockito.any())).thenReturn(new Order());

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/1"))
                .andExpect(status().isFound());
    }

    @Test
    @DisplayName("/orders/{id} with non existent id must return not found status code")
    public void testOrderIdWithNonExistentIdMustReturnNotFoundStatusCode() throws Exception {
        Mockito.when(service.findById(1))
                .thenThrow(ObjectNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.statusCode").value(404));
    }


}