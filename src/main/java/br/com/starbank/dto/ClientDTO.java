package br.com.starbank.dto;

import br.com.starbank.model.AccountModel;
import br.com.starbank.model.AddressModel;
import br.com.starbank.model.ContactModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class ClientDTO {

    private String cardHolder;
    private String mothersName;
    private String cpf;
    private String rg;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    private String nationality;
    private String uf;
    private List<AccountModel> accountType;
    private List<AddressModel> address;
    private List<ContactModel> contact;

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<AccountModel> getAccountType() {
        return accountType;
    }

    public void setAccountType(List<AccountModel> accountType) {
        this.accountType = accountType;
    }

    public List<AddressModel> getAddress() {
        return address;
    }

    public void setAddress(List<AddressModel> address) {
        this.address = address;
    }

    public List<ContactModel> getContact() {
        return contact;
    }

    public void setContact(List<ContactModel> contact) {
        this.contact = contact;
    }
}
