package com.example.br.com.curriculyan.controller.form.formacao;

import com.example.br.com.curriculyan.models.Formacao;
import com.example.br.com.curriculyan.models.Projeto;
import com.example.br.com.curriculyan.models.repository.FormacaoRepository;
import com.example.br.com.curriculyan.models.repository.ProjetoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AtualizacaoFormacaoForm {

    @NotNull
    @NotEmpty
    private String curso;
    @NotNull
    @NotEmpty
    private String instituicao;
    @NotNull
    @NotEmpty
    private LocalDate data;

   public Formacao converter() {
        return new Formacao(curso, instituicao, data);
    }

    public Formacao atualizar(Long id, FormacaoRepository formacaoRepository) {
        Formacao formacao = formacaoRepository.getReferenceById(id);
        formacao.setCurso(this.curso);
        formacao.setInstituicao(this.instituicao);
        formacao.setData(this.data);
        return formacao;
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
