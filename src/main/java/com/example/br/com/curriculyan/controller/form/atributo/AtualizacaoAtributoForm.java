package com.example.br.com.curriculyan.controller.form.atributo;

import com.example.br.com.curriculyan.models.Atributo;
import com.example.br.com.curriculyan.models.repository.AtributoRepository;

public class AtualizacaoAtributoForm {

    private String atributo;

    public Atributo atualizar(Long id, AtributoRepository atributoRepository) {
        Atributo atributo = atributoRepository.getReferenceById(id);
        atributo.setAtributo(this.atributo);
        return atributo;
    }
}
