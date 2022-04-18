package br.com.starbank.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tb_contact")
public class ContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_contact")
    private UUID id;
    private String name;
    @Column(length = 20)
    private String cellPhone;
    private String emailAddress;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
