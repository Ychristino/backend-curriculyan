package com.example.br.com.curriculyan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atributo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String atributo;
    private Long curriculoId;

    //CONSTRUTORES

    //NECESSÁRIO A DECLARAÇÃO DE CONSTRUTOR PADRÃO PARA A UTILIZAÇÃO DO JPA
    public Atributo(){}

    //CONSTRUTOR UTILIZADO PARA CADASTRO
    public Atributo(String atributo, Long curriculoId) {
        this.atributo = atributo;
        this.curriculoId = curriculoId;
    }

    //CONSTRUTOR UTILIZADO PARA ATUALIZAÇÃO
    public Atributo(String atributo) {
        this.atributo = atributo;
    }

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getAtributo() {
        return atributo;
    }
    public Long getCurriculoId() {
        return curriculoId;
    }

    //SETTERS
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
    public void setCurriculoId(Long curriculoId) {
        this.curriculoId = curriculoId;
    }
}
