package br.com.starbank.dto;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Service
public class ClientDTO {

    @NotBlank
    @Size(min = 3, max = 255)
    private String cardHolder;

    @NotBlank
    @Size(min = 3, max = 255)
    private String mothersName;

    @NotBlank
    @Size(min = 11, max = 14)
    private String cpf;

    @NotBlank
    @Size(min = 7, max = 9)
    private String rg;

//    @NotBlank
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDateTime birthDate;

//    @Valid
//    private AddressModel address;

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

//    public AddressModel getAddress() {
//        return address;
//    }
//
//    public void setAddress(AddressModel address) {
//        this.address = address;
//    }
}
