package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTypeTest {

    @Test
    @DisplayName("client type must throw IllegalArgumentException when code does not exist")
    public void clientTypeMustThrowIllegalArgumentExceptionWhenCodeDoesNotExist() {
        RuntimeException e = assertThrows(IllegalArgumentException.class, () -> {
            ClientType.toEnum(-1);
        });

        assertEquals("Invalid id: -1", e.getMessage());
    }

    @Test
    @DisplayName("client type must return null when code is null")
    public void clientTypeMustReturnNullWhenCodeIsNull() {
        assertNull(ClientType.toEnum(null));
    }


}