package io.github.pedrobicudo.projeto_modelagem_conceitual.rest.advice;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.exceptions.ObjectNotFoundException;
import io.github.pedrobicudo.projeto_modelagem_conceitual.rest.error.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StandardError handleObjectNotFoundException(ObjectNotFoundException exception) {
        return new StandardError(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                (new Date()).getTime()
        );
    }
}
