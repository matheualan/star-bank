package br.com.starbank.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_accounts")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_account")
    private UUID id;
//    private ClientModel client;
    private String accountNumber;
    private String agencyNumber;
    private String accountType;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdDate;

}
