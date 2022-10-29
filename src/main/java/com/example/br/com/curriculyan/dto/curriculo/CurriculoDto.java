package com.example.br.com.curriculyan.dto.curriculo;

import com.example.br.com.curriculyan.dto.atributo.AtributoDto;
import com.example.br.com.curriculyan.dto.experiencia.ExperienciaDto;
import com.example.br.com.curriculyan.dto.formacao.FormacaoDto;
import com.example.br.com.curriculyan.models.Curriculo;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurriculoDto {

    private Long id;
    private String atividadesAtuais;
    private String atividadesExtras;

    public CurriculoDto(Curriculo curriculo){
        this.id = curriculo.getId();
        this.atividadesAtuais = curriculo.getAtividadesAtuais();
        this.atividadesExtras = curriculo.getAtividadesExtras();
    }

    //METODOS
    public static Page<CurriculoDto> converter(Page<Curriculo> curriculos){
        return curriculos.map(CurriculoDto::new);
    }
    public static CurriculoDto converter(Curriculo curriculo){
        return new CurriculoDto(curriculo);
    }
    public Long getId() {
        return id;
    }

    //GETTERS
    public String getAtividadesAtuais() {
        return atividadesAtuais;
    }
    public String getAtividadesExtras() {
        return atividadesExtras;
    }
}
