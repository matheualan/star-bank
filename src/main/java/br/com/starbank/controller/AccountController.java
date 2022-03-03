package br.com.starbank.controller;

import br.com.starbank.dto.AccountDTO;
import br.com.starbank.service.AccountService;
import br.com.starbank.util.DateUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
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

}
