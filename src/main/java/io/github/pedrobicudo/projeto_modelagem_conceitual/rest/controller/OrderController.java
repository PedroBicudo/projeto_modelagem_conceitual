package io.github.pedrobicudo.projeto_modelagem_conceitual.rest.controller;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Order;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Order findById(
            @PathVariable("id") Integer id
    ) {
        return service.findById(id);
    }

}
