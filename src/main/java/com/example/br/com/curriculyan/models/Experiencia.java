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

    //CONSTRUTORES
    //NECESSÁRIO A DECLARAÇÃO DE CONSTRUTOR PADRÃO PARA A UTILIZAÇÃO DO JPA
    public Experiencia(){}

    //CONSTRUTOR UTILIZADO PARA CADASTRO
    public Experiencia(String cargo, String empregador, String descricao, LocalDate dataInicio, LocalDate dataFim, Long curriculoId) {
        this.cargo = cargo;
        this.empregador = empregador;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.curriculoId = curriculoId;
    }

    //CONSTRUTOR UTILIZADO PARA ATUALIZAÇÃO
    public Experiencia(String cargo, String empregador, String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.cargo = cargo;
        this.empregador = empregador;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    //GETTERS
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

    //SETTERS
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setEmpregador(String empregador) {
        this.empregador = empregador;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public void setCurriculoId(Long curriculoId) {
        this.curriculoId = curriculoId;
    }
}
