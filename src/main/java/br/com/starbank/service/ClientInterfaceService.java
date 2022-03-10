package br.com.starbank.service;

import br.com.starbank.model.ClientModel;

import java.util.List;
import java.util.UUID;

public interface ClientInterfaceService {

    List<ClientModel> findAll();
    ClientModel findById(UUID id);
    void save(ClientModel clientModel);
    void update(UUID id, ClientModel clientModel);
    void delete(UUID id);

}
