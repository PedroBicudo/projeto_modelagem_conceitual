package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum PaymentState {
    PENDING(1, "Pending"),
    ACCEPTED(2, "Accepted"),
    CANCELED(3, "Canceled");

    private final int code;
    private final String state;

    private PaymentState(int code, String state) {
        this.code = code;
        this.state = state;
    }

    public static PaymentState toEnum(Integer code) {
        if (code == null) return null;

        for (PaymentState state: PaymentState.values()) {
            if (state.getCode() == code) return state;
        }

        throw new IllegalArgumentException("Invalid id: "+code);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getState();
    }
}
