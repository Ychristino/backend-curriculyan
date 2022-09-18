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
