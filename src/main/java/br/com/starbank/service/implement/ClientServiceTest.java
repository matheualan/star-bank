package br.com.starbank.service.implement;

import br.com.starbank.model.AddressModel;
import br.com.starbank.model.ClientModel;
import br.com.starbank.repository.AddressRepository;
import br.com.starbank.repository.ClientRepository;
import br.com.starbank.service.ClientInterfaceTest;
import br.com.starbank.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceTest implements ClientInterfaceTest {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Page<ClientModel> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Optional<ClientModel> findById(UUID id) {
        return clientRepository.findById(id);
//        Optional<ClientModel> clientModelOptional = clientRepository.findById(id);
//        return clientModelOptional.get();
    }

    @Override
    public void save(ClientModel clientModel) {
        salvarClienteVerificandoCep(clientModel);
    }

    @Override
    public void update(UUID id, ClientModel clientModel) {
        Optional<ClientModel> updateClient = clientRepository.findById(id);
        if (updateClient.isPresent()) {
            salvarClienteVerificandoCep(clientModel);
        }
    }

    @Override
    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }

    private void salvarClienteVerificandoCep(ClientModel clientModel) {
        String cep = clientModel.getAddress().getCep();
        AddressModel address = addressRepository.findById(cep).orElseGet(() -> {
            AddressModel newAddress = viaCepService.consultarCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        clientModel.setAddress(address);
        clientRepository.save(clientModel);
    }

}
