package com.example.br.com.curriculyan.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String atividadesAtuais;
    private String atividadesExtras;

    @OneToMany(mappedBy = "curriculoId")
    private List<Atributo> atributos;
    @OneToMany(mappedBy = "curriculoId")
    private List<Experiencia> experiencias;
    @OneToMany(mappedBy = "curriculoId")
    private List<Formacao> formacoes;

    //CONSTRUTORES
    //NECESSÁRIO A DECLARAÇÃO DE CONSTRUTOR PADRÃO PARA A UTILIZAÇÃO DO JPA
    public Curriculo(){}

    //CONSTRUTOR UTILIZADO PARA ATUALIZAÇÃO/CADASTRO
    public Curriculo(String atividadesAtuais, String atividadesExtras) {
        this.atividadesAtuais = atividadesAtuais;
        this.atividadesExtras = atividadesExtras;
    }

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getAtividadesAtuais() {
        return atividadesAtuais;
    }
    public String getAtividadesExtras() {
        return atividadesExtras;
    }
    public List<Atributo> getAtributos() {
        return atributos;
    }
    public List<Experiencia> getExperiencias() {
        return experiencias;
    }
    public List<Formacao> getFormacoes() {
        return formacoes;
    }

    //SETTEERS
    public void setAtividadesAtuais(String atividadesAtuais) {
        this.atividadesAtuais = atividadesAtuais;
    }
    public void setAtividadesExtras(String atividadesExtras) {
        this.atividadesExtras = atividadesExtras;
    }
}
