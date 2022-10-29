package com.example.br.com.curriculyan.dto.experiencia;

import com.example.br.com.curriculyan.models.Experiencia;

import java.time.LocalDate;

public class CadastroExperienciaDto {

    private Long id;
    private String cargo;
    private String empregador;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long curriculoId;

    public CadastroExperienciaDto(Experiencia experiencia){
        this.id = experiencia.getId();
        this.cargo = experiencia.getCargo();
        this.empregador = experiencia.getEmpregador();
        this.descricao = experiencia.getDescricao();
        this.dataInicio = experiencia.getDataInicio();
        this.dataFim = experiencia.getDataFim();
        this.curriculoId = experiencia.getCurriculoId();
    }

    //GETTER
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
