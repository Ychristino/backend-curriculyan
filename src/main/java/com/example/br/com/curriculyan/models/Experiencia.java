package com.example.br.com.curriculyan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String cargo;
    private String empregador;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long curriculoId;


    public Long getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmpregador() {
        return empregador;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Long getCurriculoId() {
        return curriculoId;
    }
}
