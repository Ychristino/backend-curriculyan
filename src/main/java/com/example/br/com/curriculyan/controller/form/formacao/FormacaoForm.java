package com.example.br.com.curriculyan.controller.form.formacao;

import com.example.br.com.curriculyan.models.Formacao;
import com.example.br.com.curriculyan.models.Projeto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FormacaoForm {

    @NotNull
    @NotEmpty
    private String curso;
    @NotNull
    @NotEmpty
    private String instituicao;
    @NotNull
    @NotEmpty
    private LocalDate data;
    @NotNull
    private Long curriculoId;

    public Formacao converter() {
        return new Formacao(curso, instituicao, data, curriculoId);
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

    public Long getCurriculoId() {
        return curriculoId;
    }
}
