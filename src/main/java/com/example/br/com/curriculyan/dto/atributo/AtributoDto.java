package com.example.br.com.curriculyan.dto.atributo;

import com.example.br.com.curriculyan.models.Atributo;
import org.springframework.data.domain.Page;

public class AtributoDto {

    private Long id;
    private String descricao;
    private Long curriculoId;

    public AtributoDto(Atributo atributo){
        this.descricao = atributo.getAtributo();
        this.id = atributo.getId();
        this.curriculoId = atributo.getCurriculoId();
    }

    //METODOS (IMPLEMENTAR EM CLASSE)
    public static Page<AtributoDto> converter(Page<Atributo> atributos){
        return atributos.map(AtributoDto::new);
    }
    public static AtributoDto converter(Atributo atributo){
        return new AtributoDto(atributo);
    }

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public Long getCurriculoId() {
        return curriculoId;
    }
}
