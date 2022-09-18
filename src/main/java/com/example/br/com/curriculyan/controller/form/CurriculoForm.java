package com.example.br.com.curriculyan.controller.form;

import com.example.br.com.curriculyan.models.Curriculo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CurriculoForm {

    private String atividadesAtuais;
    private String atividadesExtras;

    public Curriculo converter() {
        return new Curriculo(atividadesAtuais, atividadesExtras);
    }

    public String getAtividadesAtuais() {
        return atividadesAtuais;
    }

    public String getAtividadesExtras() {
        return atividadesExtras;
    }
}
