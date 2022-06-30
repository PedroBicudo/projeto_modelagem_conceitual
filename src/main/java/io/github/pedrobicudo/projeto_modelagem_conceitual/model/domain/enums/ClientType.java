package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClientType {
    NATURAL_PERSON(1, "Natural Person"),
    LEGAL_ENTITY(2, "Legal Entity");

    private final int code;
    private final String description;

    public static ClientType toEnum(Integer code) {
        if (code == null) return null;

        for (ClientType type: ClientType.values()) {
            if (type.getCode() == code) return type;
        }

        throw new IllegalArgumentException("Invalid id: "+code);
    }

    private ClientType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @JsonValue
    @Override
    public String toString() {
        return description;
    }
}
