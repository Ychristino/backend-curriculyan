package com.example.br.com.curriculyan.dto;

import com.example.br.com.curriculyan.models.Formacao;

import java.time.LocalDate;

public class FormacaoDto {

    private String curso;
    private String instituicao;
    private LocalDate data;

    public FormacaoDto(Formacao formacao) {
        this.curso = formacao.getCurso();
        this.instituicao = formacao.getInstituicao();
        this.data = formacao.getData();
    }

    public String getCurso() {
        return curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public LocalDate getData() {
        return data;
    }
}
