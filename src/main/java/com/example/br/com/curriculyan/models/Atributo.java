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

    /*
    public Atributo(String descricao){
        this.descricao = descricao;
    }
    */

    public Long getId() {
        return id;
    }

    public String getAtributo() {
        return atributo;
    }

    public Long getCurriculoId() {
        return curriculoId;
    }
}
