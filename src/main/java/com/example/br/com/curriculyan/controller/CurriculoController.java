package com.example.br.com.curriculyan.controller;

import com.example.br.com.curriculyan.controller.form.curriculo.CurriculoForm;
import com.example.br.com.curriculyan.controller.form.curriculo.AtualizacaoCurriculoForm;
import com.example.br.com.curriculyan.dto.curriculo.CadastroCurriculoDto;
import com.example.br.com.curriculyan.dto.curriculo.CurriculoDto;
import com.example.br.com.curriculyan.models.Curriculo;
import com.example.br.com.curriculyan.models.repository.CurriculoRepository;
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
@RequestMapping("/curriculo")
//@CrossOrigin(origins = "https://curriculyan.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:3000")
public class CurriculoController {

    @Autowired
    private CurriculoRepository curriculoRepository;

    @GetMapping
    public Page<CurriculoDto> listar(Long id,
                                     @PageableDefault(sort = "id", size = 5, direction = Sort.Direction.ASC) Pageable paginacao){

        Page<Curriculo> curriculos = curriculoRepository.findAll(paginacao);
        return CurriculoDto.converter(curriculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurriculoDto> detalhes(@PathVariable Long id) {
        Optional<Curriculo> curriculo = curriculoRepository.findById(id);
        if (curriculo.isPresent()){
            return ResponseEntity.ok(new CurriculoDto(curriculo.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CadastroCurriculoDto> cadastrar(@RequestBody @Valid CurriculoForm form, UriComponentsBuilder uriBuilder) {
        Curriculo curriculo = form.converter();
        curriculoRepository.save(curriculo);

        URI uri = uriBuilder.path("/curriculo/{id}").buildAndExpand(curriculo.getId()).toUri();

        return ResponseEntity.created(uri).body(new CadastroCurriculoDto(curriculo));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CadastroCurriculoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCurriculoForm form){
        Optional<Curriculo> opt = curriculoRepository.findById(id);
        if (opt.isPresent()){
            Curriculo curriculo = form.atualizar(id, curriculoRepository);
            return ResponseEntity.ok(new CadastroCurriculoDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Curriculo> opt = curriculoRepository.findById(id);
        if (opt.isPresent()) {
            curriculoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
