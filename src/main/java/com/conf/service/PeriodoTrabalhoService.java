package com.conf.service;

import com.conf.model.PeriodoTrabalho;
import com.conf.repository.PeriodoTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoTrabalhoService {

    private final PeriodoTrabalhoRepository repository;

    public PeriodoTrabalhoService(PeriodoTrabalhoRepository repository) {
        this.repository = repository;
    }

    public PeriodoTrabalho salvar(PeriodoTrabalho periodo) {
        return repository.save(periodo);
    }

    public List<PeriodoTrabalho> listarPorOperacao(Long operacaoId) {
        return repository.findByOperacaoId(operacaoId);
    }
}
