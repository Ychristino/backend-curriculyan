package com.example.br.com.curriculyan.dto.formacao;

import com.example.br.com.curriculyan.dto.atributo.AtributoDto;
import com.example.br.com.curriculyan.models.Atributo;
import com.example.br.com.curriculyan.models.Formacao;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class FormacaoDto {

    private Long id;
    private String curso;
    private String instituicao;
    private LocalDate data;
    private Long curriloId;
    public FormacaoDto(Formacao formacao) {
        this.id = formacao.getId();
        this.curso = formacao.getCurso();
        this.instituicao = formacao.getInstituicao();
        this.data = formacao.getData();
        this.curriloId = formacao.getCurriculoId();
    }

    //METODOS
    public static Page<FormacaoDto> converter(Page<Formacao> formacao){
        return formacao.map(FormacaoDto::new);
    }
    public static FormacaoDto converter(Formacao formacao){
        return new FormacaoDto(formacao);
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
    public Long getCurriloId() {
        return curriloId;
    }
}
