package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.implementations;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.exceptions.ObjectNotFoundException;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService service;

    @Test
    @DisplayName("Non existent id must throw ObjectNotFoundException")
    public void testNonExistentIdMustThrowObjectNotFoundException() {
        Mockito.when(clientRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.empty());

        int id = 1;

        RuntimeException exception = assertThrows(ObjectNotFoundException.class, () -> {
            service.findById(id);
        });

        assertEquals("Object not found! id: 1, Type: Client", exception.getMessage());
    }


}