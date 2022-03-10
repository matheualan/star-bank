package br.com.starbank.controller;

import br.com.starbank.dto.ClientDTO;
import br.com.starbank.model.ClientModel;
import br.com.starbank.service.implement.ClientService;
import br.com.starbank.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

//@Api
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

//    @ApiOperation("Cadastrar um cliente por vez.")
    @PostMapping
    public ResponseEntity<ClientModel> inserirCliente(@RequestBody @Valid ClientDTO clientDTO) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /POST inserirCliente"));
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDTO, clientModel);
        clientModel.setEntryDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientModel));
    }

//    @ApiOperation("Buscar cliente por ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> findById(@PathVariable UUID id) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /GET findById"));
        Optional<ClientModel> clientModelOptional = clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientModelOptional.get());
    }

//    @ApiOperation("Listar todos clientes.")
    @GetMapping
    public ResponseEntity<Page<ClientModel>> findAll(@PageableDefault(page = 0, size = 2, sort = "id",
                                                    direction = Sort.Direction.ASC) Pageable pageable) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /GET findAll"));
        Page<ClientModel> findAll = clientService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(findAll);
    }

//    @ApiOperation("Deletar cliente por ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<ClientModel>> deleteById(@PathVariable(value = "id") UUID id) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /DELETE deleteById"));
        clientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @ApiOperation("Atualizar cliente por ID.")
    @PutMapping("/{id}")
    public ResponseEntity<ClientModel> update(@RequestBody ClientDTO clientDTO, @PathVariable(value = "id") UUID id) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /PUT update"));
        Optional<ClientModel> clientModelOptional = clientService.findById(id);
        var clientModel = new ClientModel();
        clientModel.setId(clientModelOptional.get().getId());
        clientModel.setEntryDate(clientModelOptional.get().getEntryDate());
        BeanUtils.copyProperties(clientDTO, clientModel); //Conferir se nesta posição depois de settar Id funcionar
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientModel));
    }

}
