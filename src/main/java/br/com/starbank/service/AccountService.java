package br.com.starbank.service;

import br.com.starbank.model.AccountModel;
import br.com.starbank.repository.AccountRepository;
import br.com.starbank.repository.AccountServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService implements AccountServiceInterface {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Page<AccountModel> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Optional<AccountModel> findById(UUID id) {
        return accountRepository.findById(id);
    }

    @Transactional
    @Override
    public AccountModel save(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        accountRepository.deleteById(id);
    }

}
