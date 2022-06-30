package io.github.pedrobicudo.projeto_modelagem_conceitual.rest.controller;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Client;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private IClientService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Client findById(
            @PathVariable("id") Integer id
    ) {
        return service.findById(id);
    }
}
