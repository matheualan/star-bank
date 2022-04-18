package br.com.starbank.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_contact")
public class ContactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_contact")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    @ElementCollection
    private List<String> cellPhone;
    @Column(unique = true, nullable = false)
    private String emailAddress;
    @CreationTimestamp
    private LocalDateTime creatAt;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(List<String> cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }
}
