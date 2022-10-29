package com.example.br.com.curriculyan.controller.form.curriculo;

import com.example.br.com.curriculyan.models.Curriculo;
import com.example.br.com.curriculyan.models.repository.CurriculoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoCurriculoForm {

    @NotEmpty
    @NotNull
    private String atividadesAtuais;
    @NotEmpty
    @NotNull
    private String atividadesExtras;

    public Curriculo converter() {
        return new Curriculo(atividadesAtuais, atividadesExtras);
    }

    public Curriculo atualizar(Long id, CurriculoRepository curriculoRepository) {
        Curriculo curriculo = curriculoRepository.getReferenceById(id);
        curriculo.setAtividadesAtuais(this.atividadesAtuais);
        curriculo.setAtividadesExtras(this.atividadesExtras);
        return curriculo;
    }

    public String getAtividadesAtuais() {
        return atividadesAtuais;
    }

    public String getAtividadesExtras() {
        return atividadesExtras;
    }
}