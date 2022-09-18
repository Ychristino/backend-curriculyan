package com.example.br.com.curriculyan.models.repository;

import com.example.br.com.curriculyan.models.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {

}
