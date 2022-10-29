package com.example.br.com.curriculyan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URI;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    private String link;

    //CONSTRUTORES
    //NECESSÁRIO A DECLARAÇÃO DE CONSTRUTOR PADRÃO PARA A UTILIZAÇÃO DO JPA
    public Projeto(){}

    //CONSTRUTOR UTILIZADO PARA ATUALIZAÇÃO/CADASTRO
    public Projeto(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = url;
    }

    // GETTERS
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getLink() {
        return link;
    }

    // SETTERS
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
