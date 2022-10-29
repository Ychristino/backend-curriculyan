package com.example.br.com.curriculyan.controller.form;

import com.example.br.com.curriculyan.models.Curriculo;
import com.example.br.com.curriculyan.models.repository.CurriculoRepository;

public class atualizacaoCurriculoForm {

    private String atividadesAtuais;
    private String atividadesExtras;

    public String getAtividadesAtuais() {
        return atividadesAtuais;
    }

    public String getAtividadesExtras() {
        return atividadesExtras;
    }

    public void setAtividadesAtuais(String atividadesAtuais) {
        this.atividadesAtuais = atividadesAtuais;
    }

    public void setAtividadesExtras(String atividadesExtras) {
        this.atividadesExtras = atividadesExtras;
    }

    public Curriculo converter() {
        return new Curriculo(atividadesAtuais, atividadesExtras);
    }

    public Curriculo atualizar(Long id, CurriculoRepository curriculoRepository) {
        Curriculo curriculo = curriculoRepository.getReferenceById(id);
        curriculo.setAtividadesAtuais(this.atividadesAtuais);
        curriculo.setAtividadesExtras(this.atividadesExtras);
        return curriculo;
    }
}