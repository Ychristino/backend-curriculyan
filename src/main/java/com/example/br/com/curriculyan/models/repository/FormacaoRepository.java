package com.example.br.com.curriculyan.models.repository;

import com.example.br.com.curriculyan.models.Formacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormacaoRepository extends JpaRepository<Formacao, Long> {
    Page<Formacao> findAllByCurriculoId(Long curriculoId, Pageable paginacao);
}
