package br.com.starbank.repository;

import br.com.starbank.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientServiceInterface {

    ClientModel save(ClientModel clientModel);
    Page<ClientModel> getAll(Pageable pageable);
    Optional<ClientModel> getById(UUID id);
    void deleteById(UUID id);

}
