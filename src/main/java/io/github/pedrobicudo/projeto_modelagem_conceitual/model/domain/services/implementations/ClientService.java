package io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.implementations;

import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.entities.Client;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.exceptions.ObjectNotFoundException;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.repositories.ClientRepository;
import io.github.pedrobicudo.projeto_modelagem_conceitual.model.domain.services.interfaces.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public Client findById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> {
                    return new ObjectNotFoundException(
                            "Object not found! id: "+id+
                                    ", Type: "+ Client.class.getSimpleName()
                    );
                });
    }
}
