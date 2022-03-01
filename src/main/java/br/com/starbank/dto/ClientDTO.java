package br.com.starbank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ClientDTO {

    @NotBlank
    @Size(min = 7, max = 255)
    private String cardHolder;
    @NotBlank
    @Size(min = 7, max = 255)
    private String mothersName;
    @NotBlank
    @Size(min = 11, max = 14)
    private String cpf;
    @NotBlank
    @Size(min = 7, max = 9)
    private String rg;
//    @NotBlank
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private Date birthDate;
    @NotBlank
    private String nationality;
    @NotBlank //Fazer teste se usando Size precisa ter o NotBlank
    @Size(min = 2, max = 2, message = "O campo 'UF' deve conter 2 caracteres.")
    private String uf;
//    private List<AccountModel> accountType;
//    private List<AddressModel> address;
//    private List<ContactModel> contact;

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

//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }

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

//    public List<AccountModel> getAccountType() {
//        return accountType;
//    }
//
//    public void setAccountType(List<AccountModel> accountType) {
//        this.accountType = accountType;
//    }
//
//    public List<AddressModel> getAddress() {
//        return address;
//    }
//
//    public void setAddress(List<AddressModel> address) {
//        this.address = address;
//    }
//
//    public List<ContactModel> getContact() {
//        return contact;
//    }
//
//    public void setContact(List<ContactModel> contact) {
//        this.contact = contact;
//    }
}
