package com.example.br.com.curriculyan.controller.form.experiencia;

import com.example.br.com.curriculyan.models.Experiencia;
import com.example.br.com.curriculyan.models.repository.ExperienciaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AtualizacaoExperienciaForm {

    @NotNull
    @NotEmpty
    private String cargo;
    @NotNull
    @NotEmpty
    private String empregador;
    @NotNull
    @NotEmpty
    private String descricao;
    @NotNull
    @NotEmpty
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Experiencia converter() {
        return new Experiencia(cargo, empregador, descricao, dataInicio, dataFim);
    }

    public Experiencia atualizar(Long id, ExperienciaRepository experienciaRepository) {
        Experiencia experiencia = experienciaRepository.getReferenceById(id);
        experiencia.setCargo(this.cargo);
        experiencia.setEmpregador(this.empregador);
        experiencia.setDescricao(this.descricao);
        experiencia.setDataInicio(this.dataInicio);
        experiencia.setDataFim(this.dataFim);
        return experiencia;
    }
}
