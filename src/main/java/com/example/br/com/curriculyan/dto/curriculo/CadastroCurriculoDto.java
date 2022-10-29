package com.example.br.com.curriculyan.dto.curriculo;

import com.example.br.com.curriculyan.models.Curriculo;

public class CadastroCurriculoDto {

    private Long id;
    private String atividadesAtuais;
    private String atividadesExtras;

    public CadastroCurriculoDto(Curriculo curriculo){
        this.id = curriculo.getId();
        this.atividadesAtuais = curriculo.getAtividadesAtuais();
        this.atividadesExtras = curriculo.getAtividadesExtras();
    }

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getAtividadesAtuais() {
        return atividadesAtuais;
    }
    public String getAtividadesExtras() {
        return atividadesExtras;
    }

}

