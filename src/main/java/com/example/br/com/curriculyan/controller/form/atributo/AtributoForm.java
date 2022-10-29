package com.example.br.com.curriculyan.controller.form.atributo;

import com.example.br.com.curriculyan.models.Atributo;

public class AtributoForm {
    private String atributo;
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
