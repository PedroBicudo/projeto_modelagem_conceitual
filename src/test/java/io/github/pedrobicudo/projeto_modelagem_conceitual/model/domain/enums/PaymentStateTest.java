package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentStateTest {

    @Test
    @DisplayName("payment statemust throw IllegalArgumentException when code does not exist")
    public void paymentStateMustThrowIllegalArgumentExceptionWhenCodeDoesNotExist() {
        RuntimeException e = assertThrows(IllegalArgumentException.class, () -> {
            PaymentState.toEnum(-1);
        });

        assertEquals("Invalid id: -1", e.getMessage());
    }

    @Test
    @DisplayName("payment statemust return null when code is null")
    public void paymentStateMustReturnNullWhenCodeIsNull() {
        assertNull(PaymentState.toEnum(null));
    }


}