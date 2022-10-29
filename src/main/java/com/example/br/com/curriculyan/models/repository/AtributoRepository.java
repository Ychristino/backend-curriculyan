package com.example.br.com.curriculyan.models.repository;

import com.example.br.com.curriculyan.models.Atributo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtributoRepository extends JpaRepository<Atributo, Long> {
    Page<Atributo> findAllByCurriculoId(Long curriculoId, Pageable paginacao);
}
