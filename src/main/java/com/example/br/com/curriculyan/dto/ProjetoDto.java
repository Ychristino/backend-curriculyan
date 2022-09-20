package com.example.br.com.curriculyan.dto;

import com.example.br.com.curriculyan.models.Projeto;
import org.springframework.data.domain.Page;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

public class ProjetoDto {

    private String titulo;
    private String descricao;
    private String link;

    public ProjetoDto(Projeto projeto) {
        this.titulo = projeto.getTitulo();
        this.descricao = projeto.getDescricao();
        this.link = projeto.getLink();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLink() {
        return link;
    }

    public static Page<ProjetoDto> converter(Page<Projeto> projeto){
        return projeto.map(ProjetoDto::new);
    }
    public static ProjetoDto converter(Projeto projeto){
        return new ProjetoDto(projeto);
    }
}
