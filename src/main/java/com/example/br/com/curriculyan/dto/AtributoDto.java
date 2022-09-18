package com.example.br.com.curriculyan.dto;

import com.example.br.com.curriculyan.models.Atributo;

public class AtributoDto {

    private String descricao;

    public AtributoDto(Atributo atributo){
        this.descricao = atributo.getAtributo();
    }

    public String getDescricao() {
        return descricao;
    }
}
