package com.example.br.com.curriculyan.controller.form.atributo;

import com.example.br.com.curriculyan.models.Atributo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtributoForm {

    @NotNull @NotEmpty
    private String atributo;
    @NotNull
    private Long curriculoId;

    public Atributo converter() {
        return new Atributo(atributo, curriculoId);
    }


    public String getAtributo() {
        return atributo;
    }

    public Long getCurriculoId() {
        return curriculoId;
    }
}
