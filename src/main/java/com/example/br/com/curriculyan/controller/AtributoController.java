package com.example.br.com.curriculyan.controller;

import com.example.br.com.curriculyan.controller.form.atributo.AtributoForm;
import com.example.br.com.curriculyan.controller.form.atributo.AtualizacaoAtributoForm;
import com.example.br.com.curriculyan.dto.atributo.AtributoDto;
import com.example.br.com.curriculyan.dto.atributo.CadastroAtributoDto;
import com.example.br.com.curriculyan.models.Atributo;
import com.example.br.com.curriculyan.models.repository.AtributoRepository;
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
@RequestMapping("/atributo")
//@CrossOrigin(origins = "https://curriculyan.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:3000")
public class AtributoController {

    @Autowired
    private AtributoRepository atributoRepository;

    @GetMapping
    public Page<AtributoDto> listar(@PageableDefault(sort = "atributo", direction = Sort.Direction.ASC) Pageable paginacao,
                                    @RequestParam(required = true) Long curriculoId){

        Page<Atributo> atributos = atributoRepository.findAllByCurriculoId(curriculoId, paginacao);
        return AtributoDto.converter(atributos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtributoDto> detalhes(@PathVariable Long id) {
        Optional<Atributo> atributo = atributoRepository.findById(id);
        if (atributo.isPresent()){
            return ResponseEntity.ok(new AtributoDto(atributo.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CadastroAtributoDto> cadastrar(@RequestBody @Valid AtributoForm form, UriComponentsBuilder uriBuilder) {
        Atributo atributo = form.converter();
        atributoRepository.save(atributo);

        URI uri = uriBuilder.path("/atributo/{id}").buildAndExpand(atributo.getId()).toUri();

        return ResponseEntity.created(uri).body(new CadastroAtributoDto(atributo));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CadastroAtributoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAtributoForm form){
        Optional<Atributo> opt = atributoRepository.findById(id);
        if (opt.isPresent()){
            Atributo atributo = form.atualizar(id, atributoRepository);
            return ResponseEntity.ok(new CadastroAtributoDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Atributo> opt = atributoRepository.findById(id);
        if (opt.isPresent()) {
            atributoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
