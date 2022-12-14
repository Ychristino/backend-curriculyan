package com.example.br.com.curriculyan.controller;

import com.example.br.com.curriculyan.controller.form.projeto.ProjetoForm;
import com.example.br.com.curriculyan.controller.form.projeto.AtualizacaoProjetoForm;
import com.example.br.com.curriculyan.dto.projeto.ProjetoDto;
import com.example.br.com.curriculyan.models.Projeto;
import com.example.br.com.curriculyan.models.repository.ProjetoRepository;
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
@RequestMapping("/projeto")
//@CrossOrigin(origins = "https://curriculyan.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:3000")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping
    public Page<ProjetoDto> listar(@PageableDefault(sort = "titulo",  direction = Sort.Direction.ASC) Pageable paginacao){
        Page<Projeto> projeto = projetoRepository.findAll(paginacao);
        return ProjetoDto.converter(projeto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDto> detalhes(@PathVariable Long id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if (projeto.isPresent()){
            return ResponseEntity.ok(new ProjetoDto(projeto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProjetoDto> cadastrar(@RequestBody @Valid ProjetoForm form, UriComponentsBuilder uriBuilder) {
        Projeto projeto = form.converter();
        projetoRepository.save(projeto);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(projeto.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProjetoDto(projeto));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProjetoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoProjetoForm form){
        Optional<Projeto> opt = projetoRepository.findById(id);
        if (opt.isPresent()){
            Projeto projeto = form.atualizar(id, projetoRepository);
            return ResponseEntity.ok(new ProjetoDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Projeto> opt = projetoRepository.findById(id);
        if (opt.isPresent()) {
            projetoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
