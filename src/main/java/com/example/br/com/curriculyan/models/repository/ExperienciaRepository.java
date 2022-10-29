package com.example.br.com.curriculyan.models.repository;

import com.example.br.com.curriculyan.models.Experiencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    Page<Experiencia> findAllByCurriculoId(Long curriculoId, Pageable paginacao);
}
