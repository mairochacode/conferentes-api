package com.conf.repository;

import com.conf.model.PeriodoTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeriodoTrabalhoRepository extends JpaRepository<PeriodoTrabalho, Long> {
    List<PeriodoTrabalho> findByOperacaoId(Long operacaoId);
}
