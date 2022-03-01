package br.com.starbank.controller;

import br.com.starbank.dto.ClientDTO;
import br.com.starbank.model.ClientModel;
import br.com.starbank.repository.ClientRepository;
import br.com.starbank.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Log4j2
@RestController
@RequestMapping("/client")
public class ClientController {

    private final DateUtil dateUtil;
    private final ClientRepository clientRepository;
    private final ClientDTO clientDTO;

    public ClientController(DateUtil dateUtil, ClientRepository clientRepository, ClientDTO clientDTO) {
        this.dateUtil = dateUtil;
        this.clientRepository = clientRepository;
        this.clientDTO = clientDTO;
    }

    @PostMapping
    public ResponseEntity<ClientModel> inserirCliente(@RequestBody @Valid ClientDTO clientDTO) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /POST inserirCliente"));
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDTO, clientModel);
        clientModel.setEntryDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientModel));
    }

//    @PostMapping
//    public ResponseEntity<ClientModel> insertClient(@RequestBody ClientModel clientModel) {
//        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /POST - insertClient"));
//        ClientModel client = clientRepository.save(clientModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(client);
//    }

}
