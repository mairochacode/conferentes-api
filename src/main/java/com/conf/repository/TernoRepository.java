package com.conf.repository;

import com.conf.model.Terno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TernoRepository extends JpaRepository<Terno, Long> {
    List<Terno> findByOperacaoId(Long operacaoId);
}
