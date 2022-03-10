package br.com.starbank.service.implement;

import br.com.starbank.model.ClientModel;
import br.com.starbank.repository.AddressRepository;
import br.com.starbank.repository.ClientRepository;
import br.com.starbank.service.ClientInterfaceService;
import br.com.starbank.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceTest implements ClientInterfaceService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<ClientModel> findAll() {
        return null;
    }

    @Override
    public ClientModel findById(UUID id) {
        return null;
    }

    @Override
    public void save(ClientModel clientModel) {

    }

    @Override
    public void update(UUID id, ClientModel clientModel) {

    }

    @Override
    public void delete(UUID id) {

    }

}
