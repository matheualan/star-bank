package br.com.starbank.service;

import br.com.starbank.model.ClientModel;
import br.com.starbank.repository.ClientRepository;
import br.com.starbank.repository.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientModel save(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    @Override
    public Page<ClientModel> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Optional<ClientModel> findById(UUID id) {
        return clientRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }
}
