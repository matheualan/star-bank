package br.com.starbank.controller;

import br.com.starbank.dto.AccountDTO;
import br.com.starbank.model.AccountModel;
import br.com.starbank.service.AccountService;
import br.com.starbank.util.DateUtil;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Api
@Log4j2
@RestController
@RequestMapping(path = "/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountDTO accountDTO;
    private final DateUtil dateUtil;

    public AccountController(AccountService accountService, AccountDTO accountDTO, DateUtil dateUtil) {
        this.accountService = accountService;
        this.accountDTO = accountDTO;
        this.dateUtil = dateUtil;
    }

    @PostMapping
    public ResponseEntity<AccountModel> insert(@RequestBody AccountDTO accountDTO) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /POST insert"));
        var accountModel = new AccountModel();
        BeanUtils.copyProperties(accountDTO, accountModel);
        accountModel.setCreatedDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountModel));
    }

    @GetMapping
    public ResponseEntity<Page<AccountModel>> findAll(@PageableDefault(page = 0, size = 2, sort = "id",
                                                    direction = Sort.Direction.ASC) Pageable pageable) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /GET findAll"));
        Page<AccountModel> accountPage = accountService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(accountPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AccountModel>> findById(@PathVariable(value = "id") UUID id) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /GET findById"));
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
//        return ResponseEntity.ok(accountService.findById(id));
    }

}
