package br.com.starbank.dto;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

@Service
public class AccountDTO {

    @NotBlank
    private String accountNumber;
    @NotBlank
    private String agencyNumber;
    @NotBlank
    private String accountType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
