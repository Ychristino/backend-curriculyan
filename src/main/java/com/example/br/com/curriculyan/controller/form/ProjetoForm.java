package com.example.br.com.curriculyan.controller.form;

import com.example.br.com.curriculyan.models.Projeto;

import java.net.URI;

public class ProjetoForm {
    private String titulo;
    private String descricao;
    private String link;

    public Projeto converter() {
        return new Projeto(titulo, descricao, link);
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
}
