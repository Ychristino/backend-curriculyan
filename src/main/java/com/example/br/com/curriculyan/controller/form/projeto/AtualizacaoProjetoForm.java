package com.example.br.com.curriculyan.controller.form.projeto;

import com.example.br.com.curriculyan.models.Formacao;
import com.example.br.com.curriculyan.models.Projeto;
import com.example.br.com.curriculyan.models.repository.ProjetoRepository;

import java.time.LocalDate;

public class AtualizacaoProjetoForm {

    private String titulo;
    private String descricao;
    private String link;

    public Projeto converter() {
        return new Projeto(titulo, descricao, link);
    }

    public Projeto atualizar(Long id, ProjetoRepository projetoRepository) {
        Projeto projeto = projetoRepository.getReferenceById(id);
        projeto.setTitulo(this.titulo);
        projeto.setDescricao(this.descricao);
        projeto.setLink(this.link);
        return projeto;
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
