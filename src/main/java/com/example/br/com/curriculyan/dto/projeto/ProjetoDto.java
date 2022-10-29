package com.example.br.com.curriculyan.dto.projeto;

import com.example.br.com.curriculyan.models.Projeto;
import org.springframework.data.domain.Page;

public class ProjetoDto {

    private Long id;
    private String titulo;
    private String descricao;
    private String link;
    public ProjetoDto(Projeto projeto) {
        this.id = projeto.getId();
        this.titulo = projeto.getTitulo();
        this.descricao = projeto.getDescricao();
        this.link = projeto.getLink();
    }

    //METODOS
    public static Page<ProjetoDto> converter(Page<Projeto> projeto){
        return projeto.map(ProjetoDto::new);
    }
    public static ProjetoDto converter(Projeto projeto){
        return new ProjetoDto(projeto);
    }

    //GETTERS
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLink() {
        return link;
    }
}
