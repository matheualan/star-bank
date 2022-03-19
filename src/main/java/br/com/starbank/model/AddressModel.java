package br.com.starbank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_enderecos")
public class AddressModel {

    @Id
    @Column()
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
//    @Column(length = 2)
    private String uf;
//    @Column(length = 2)
    private String ddd;

//    @JsonIgnore
//    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "address")
//    private List<ClientModel> clientModel = new ArrayList<>();

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

//    public List<ClientModel> getClientModel() {
//        return clientModel;
//    }
//
//    public void setClientModel(List<ClientModel> clientModel) {
//        this.clientModel = clientModel;
//    }
}
