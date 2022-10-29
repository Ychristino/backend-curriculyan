package com.example.br.com.curriculyan.controller.form.atributo;

import com.example.br.com.curriculyan.models.Atributo;
import com.example.br.com.curriculyan.models.Projeto;
import com.example.br.com.curriculyan.models.repository.AtributoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoAtributoForm {

    @NotNull @NotEmpty
    private String atributo;

    public Atributo converter() {
        return new Atributo(atributo);
    }

    public Atributo atualizar(Long id, AtributoRepository atributoRepository) {
        Atributo atributo = atributoRepository.getReferenceById(id);
        atributo.setAtributo(this.atributo);
        return atributo;
    }
}
