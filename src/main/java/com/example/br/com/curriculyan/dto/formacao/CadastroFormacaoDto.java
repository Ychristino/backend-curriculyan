package com.example.br.com.curriculyan.dto.formacao;

import com.example.br.com.curriculyan.models.Atributo;
import com.example.br.com.curriculyan.models.Formacao;

import java.time.LocalDate;

public class CadastroFormacaoDto {

    private Long id;
    private String curso;
    private String instituicao;
    private LocalDate data;
    private Long curriculoId;

    public CadastroFormacaoDto(Formacao formacao){
        this.id = formacao.getId();
        this.curso = formacao.getCurso();
        this.instituicao = formacao.getInstituicao();
        this.data = formacao.getData();
        this.curriculoId = formacao.getCurriculoId();
    }

    //GETTERS
    public Long getId() {
        return id;
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
