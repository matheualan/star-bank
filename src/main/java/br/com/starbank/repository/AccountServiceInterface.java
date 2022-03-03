package br.com.starbank.repository;

import br.com.starbank.model.AccountModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface AccountServiceInterface {

    Page<AccountModel> findAll(Pageable pageable);
    Optional<AccountModel> findById(UUID id);
    AccountModel save(AccountModel accountModel);
    void deleteById(UUID id);

}
