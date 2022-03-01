package br.com.starbank.repository;

import br.com.starbank.model.ClientModel;

import java.util.List;
import java.util.UUID;

public interface ClientServiceInterface {

    ClientModel save(ClientModel clientModel);
    List<ClientModel> getAll();
    void getById(UUID id);
    void deleteById(UUID id);

}
