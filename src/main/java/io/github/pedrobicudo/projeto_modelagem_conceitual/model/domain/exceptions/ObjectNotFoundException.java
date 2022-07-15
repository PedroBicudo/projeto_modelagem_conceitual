package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Integer id, Class<?> entity) {
        super("Object not found! id: "+id+", Type: "+ entity.getSimpleName());
    }
}
