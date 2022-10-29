package com.example.br.com.curriculyan.dto;

import com.example.br.com.curriculyan.models.Experiencia;

import java.time.LocalDate;

public class ExperienciaDto {

    private String cargo;
    private String empregador;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public ExperienciaDto(Experiencia experiencia) {
        this.cargo = experiencia.getCargo();
        this.empregador = experiencia.getEmpregador();
        this.descricao = experiencia.getDescricao();
        this.dataInicio = experiencia.getDataInicio();
        this.dataFim = experiencia.getDataFim();
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
}
