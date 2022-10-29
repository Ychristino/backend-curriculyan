package com.example.br.com.curriculyan.dto;

import com.example.br.com.curriculyan.models.Atributo;
import com.example.br.com.curriculyan.models.Curriculo;
import org.springframework.data.domain.Page;

public class AtributoDto {

    private Long id;
    private String descricao;

    public AtributoDto(Atributo atributo){
        this.descricao = atributo.getAtributo();
        this.id = atributo.getId();
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

    public static Page<AtributoDto> converter(Page<Atributo> atributos){
        return atributos.map(AtributoDto::new);
    }
    public static AtributoDto converter(Atributo atributo){
        return new AtributoDto(atributo);
    }
}
