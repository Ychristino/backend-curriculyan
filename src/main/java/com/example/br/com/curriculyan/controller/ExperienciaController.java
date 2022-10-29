package com.example.br.com.curriculyan.controller;

import com.example.br.com.curriculyan.controller.form.experiencia.AtualizacaoExperienciaForm;
import com.example.br.com.curriculyan.controller.form.experiencia.ExperienciaForm;
import com.example.br.com.curriculyan.dto.experiencia.CadastroExperienciaDto;
import com.example.br.com.curriculyan.dto.experiencia.ExperienciaDto;
import com.example.br.com.curriculyan.models.Experiencia;
import com.example.br.com.curriculyan.models.repository.ExperienciaRepository;
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
@RequestMapping("/experiencia")
//@CrossOrigin(origins = "https://curriculyan.herokuapp.com")
//@CrossOrigin(origins = "http://localhost:3000")
public class ExperienciaController {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @GetMapping
    public Page<ExperienciaDto> listar(@PageableDefault(sort = {"dataFim", "dataInicio"}, size = 10, direction = Sort.Direction.DESC) Pageable paginacao,
                                       @RequestParam(required = true) Long curriculoId){

        Page<Experiencia> experiencias = experienciaRepository.findAllByCurriculoId(curriculoId, paginacao);
        return ExperienciaDto.converter(experiencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienciaDto> detalhes(@PathVariable Long id) {
        Optional<Experiencia> experiencia = experienciaRepository.findById(id);
        if (experiencia.isPresent()){
            return ResponseEntity.ok(new ExperienciaDto(experiencia.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CadastroExperienciaDto> cadastrar(@RequestBody @Valid  ExperienciaForm form, UriComponentsBuilder uriBuilder) {
        Experiencia experiencia = form.converter();
        experienciaRepository.save(experiencia);

        URI uri = uriBuilder.path("/experiencia/{id}").buildAndExpand(experiencia.getId()).toUri();

        return ResponseEntity.created(uri).body(new CadastroExperienciaDto(experiencia));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CadastroExperienciaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoExperienciaForm form){
        Optional<Experiencia> opt = experienciaRepository.findById(id);
        if (opt.isPresent()){
            Experiencia experiencia = form.atualizar(id, experienciaRepository);
            return ResponseEntity.ok(new CadastroExperienciaDto(opt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Experiencia> opt = experienciaRepository.findById(id);
        if (opt.isPresent()) {
            experienciaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
