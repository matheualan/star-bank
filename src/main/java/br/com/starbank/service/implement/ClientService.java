package br.com.starbank.service.implement;

import br.com.starbank.model.ClientModel;
import br.com.starbank.repository.ClientRepository;
import br.com.starbank.repository.ClientServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService implements ClientServiceInterface {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<ClientModel> findById(UUID id) {
        return clientRepository.findById(id);
    }

    @Override
    public Page<ClientModel> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public ClientModel save(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }
}
