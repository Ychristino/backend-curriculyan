package com.example.br.com.curriculyan.dto;

import com.example.br.com.curriculyan.models.Curriculo;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurriculoDto {

    private Long id;
    private String atividadesAtuais;
    private String atividadesExtras;

    private List<AtributoDto> atributos;
    private List<ExperienciaDto> experiencias;
    private List<FormacaoDto> formacoes;

    public CurriculoDto(Curriculo curriculo){
        this.id = curriculo.getId();
        this.atividadesAtuais = curriculo.getAtividadesAtuais();
        this.atividadesExtras = curriculo.getAtividadesExtras();


        this.atributos = new ArrayList<>();
        this.atributos.addAll(curriculo.getAtributos().stream().map(AtributoDto::new).collect(Collectors.toList()));

        this.experiencias = new ArrayList<>();
        this.experiencias.addAll(curriculo.getExperiencias().stream().map(ExperienciaDto::new).collect(Collectors.toList()));

        this.formacoes = new ArrayList<>();
        this.formacoes.addAll(curriculo.getFormacoes().stream().map(FormacaoDto::new).collect(Collectors.toList()));

    }
    public Long getId() {
        return id;
    }

    public String getAtividadesAtuais() {
        return atividadesAtuais;
    }

    public String getAtividadesExtras() {
        return atividadesExtras;
    }

    public List<AtributoDto> getAtributos() {
        return atributos;
    }

    public List<ExperienciaDto> getExperiencias() {
        return experiencias;
    }

    public List<FormacaoDto> getFormacoes() {
        return formacoes;
    }

    public static Page<CurriculoDto> converter(Page<Curriculo> curriculos){
        return curriculos.map(CurriculoDto::new);
    }
    public static CurriculoDto converter(Curriculo curriculo){
            return new CurriculoDto(curriculo);
    }

}
