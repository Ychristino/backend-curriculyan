package com.example.br.com.curriculyan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String curso;
    private String instituicao;
    private LocalDate data;
    private Long curriculoId;

    //CONSTRUTORES
    //NECESSÁRIO A DECLARAÇÃO DE CONSTRUTOR PADRÃO PARA A UTILIZAÇÃO DO JPA
    public Formacao(){}

    //CONSTRUTOR UTILIZADO PARA CADASTRO
    public Formacao(String curso, String instituicao, LocalDate data, Long curriculoId) {
        this.curso = curso;
        this.instituicao = instituicao;
        this.data = data;
        this.curriculoId = curriculoId;
    }

    //CONSTRUTOR UTILIZADO PARA ATUALIZAÇÃO
    public Formacao(String curso, String instituicao, LocalDate data) {
        this.curso = curso;
        this.instituicao = instituicao;
        this.data = data;
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

    //SETTERS
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public void setCurriculoId(Long curriculoId) {
        this.curriculoId = curriculoId;
    }
}
