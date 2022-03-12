package br.com.starbank.service;

import br.com.starbank.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ClientInterfaceTest {

    Page<ClientModel> findAll(Pageable pageable);
    Optional<ClientModel> findById(UUID id);
    void deleteById(UUID id);
    void save(ClientModel clientModel);
    void update(UUID id, ClientModel clientModel);

}
