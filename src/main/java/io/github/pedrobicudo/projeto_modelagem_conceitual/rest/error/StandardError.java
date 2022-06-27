package io.github.pedrobicudo.projeto_modelagem_conceitual.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {
    private Integer statusCode;
    private String msg;
    private Long timestamp;
}
