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

    public Curriculo(){}

    public Curriculo(String atividadesAtuais, String atividadesExtras) {
        this.atividadesAtuais = atividadesAtuais;
        this.atividadesExtras = atividadesExtras;
    }

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


    public void setId(Long id) {
        this.id = id;
    }

    public void setAtividadesAtuais(String atividadesAtuais) {
        this.atividadesAtuais = atividadesAtuais;
    }

    public void setAtividadesExtras(String atividadesExtras) {
        this.atividadesExtras = atividadesExtras;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public void setFormacoes(List<Formacao> formacoes) {
        this.formacoes = formacoes;
    }
}
