package com.example.br.com.curriculyan.dto.atributo;

import com.example.br.com.curriculyan.models.Atributo;

public class CadastroAtributoDto {

    private Long id;
    private String atributo;
    private Long curriculoId;

    public CadastroAtributoDto(Atributo atributo){
        this.id = atributo.getId();
        this.atributo = atributo.getAtributo();
        this.curriculoId = atributo.getCurriculoId();
    }

    //GETTERS
    public Long getId() {
        return id;
    }

    public String getAtributo() {
        return atributo;
    }

    public Long getCurriculoId() {
        return curriculoId;
    }
}
