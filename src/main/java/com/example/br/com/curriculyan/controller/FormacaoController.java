package com.example.br.com.curriculyan.controller;

import com.example.br.com.curriculyan.controller.form.curriculo.CurriculoForm;
import com.example.br.com.curriculyan.controller.form.formacao.AtualizacaoFormacaoForm;
import com.example.br.com.curriculyan.controller.form.formacao.FormacaoForm;
import com.example.br.com.curriculyan.controller.form.projeto.AtualizacaoProjetoForm;
import com.example.br.com.curriculyan.dto.curriculo.CadastroCurriculoDto;
import com.example.br.com.curriculyan.dto.curriculo.CurriculoDto;
import com.example.br.com.curriculyan.dto.formacao.CadastroFormacaoDto;
import com.example.br.com.curriculyan.dto.formacao.FormacaoDto;
import com.example.br.com.curriculyan.dto.projeto.ProjetoDto;
import com.example.br.com.curriculyan.models.Curriculo;
import com.example.br.com.curriculyan.models.Formacao;
import com.example.br.com.curriculyan.models.Projeto;
import com.example.br.com.curriculyan.models.repository.CurriculoRepository;
import com.example.br.com.curriculyan.models.repository.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/formacao")
//@CrossOrigin(origins = "https://curriculyan.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:3000")
public class FormacaoController {

    @Autowired
    private FormacaoRepository formacaoRepository;

    @GetMapping
    public Page<FormacaoDto> listar(@PageableDefault(sort = "data", size = 10, direction = Sort.Direction.DESC) Pageable paginacao,
                                    @RequestParam(required = true) Long curriculoId){

        Page<Formacao> formacoes = formacaoRepository.findAllByCurriculoId(curriculoId, paginacao);
        return FormacaoDto.converter(formacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormacaoDto> detalhes(@PathVariable Long id) {
        Optional<Formacao> formacao = formacaoRepository.findById(id);
        if (formacao.isPresent()){
            return ResponseEntity.ok(new FormacaoDto(formacao.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CadastroFormacaoDto> cadastrar(@RequestBody @Valid FormacaoForm form, UriComponentsBuilder uriBuilder) {
        Formacao formacao = form.converter();
        formacaoRepository.save(formacao);

        URI uri = uriBuilder.path("/formacao/{id}").buildAndExpand(formacao.getId()).toUri();

        return ResponseEntity.created(uri).body(new CadastroFormacaoDto(formacao));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FormacaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoFormacaoForm form){
        Optional<Formacao> opt = formacaoRepository.findById(id);
        if (opt.isPresent()){
            Formacao formacao = form.atualizar(id, formacaoRepository);
            return ResponseEntity.ok(new FormacaoDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Formacao> opt = formacaoRepository.findById(id);
        if (opt.isPresent()) {
            formacaoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
