package com.example.br.com.curriculyan.controller.form.experiencia;

import com.example.br.com.curriculyan.models.Experiencia;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ExperienciaForm {

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
    @NotNull
    private Long curriculoId;

    public Experiencia converter() {
        return new Experiencia(cargo, empregador, descricao, dataInicio, dataFim, curriculoId);
    }

}
