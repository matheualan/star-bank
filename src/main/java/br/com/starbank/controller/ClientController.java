package br.com.starbank.controller;

import br.com.starbank.dto.ClientDTO;
import br.com.starbank.model.ClientModel;
import br.com.starbank.repository.ClientRepository;
import br.com.starbank.service.ClientService;
import br.com.starbank.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("/client")
public class ClientController {

    private final DateUtil dateUtil;
    private final ClientService clientService;
    private final ClientDTO clientDTO;

    public ClientController(DateUtil dateUtil, ClientService clientService, ClientDTO clientDTO) {
        this.dateUtil = dateUtil;
        this.clientService = clientService;
        this.clientDTO = clientDTO;
    }

    @PostMapping
    public ResponseEntity<ClientModel> inserirCliente(@RequestBody @Valid ClientDTO clientDTO) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /POST inserirCliente"));
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDTO, clientModel);
        clientModel.setEntryDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> findById(@PathVariable UUID id) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /GET findById"));
        Optional<ClientModel> clientModelOptional = clientService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientModelOptional.get());
    }


}
