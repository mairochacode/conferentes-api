package com.conf.service;

import com.conf.model.Operacao;
import com.conf.repository.OperacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperacaoService {

    private final OperacaoRepository operacaoRepository;

    public OperacaoService(OperacaoRepository operacaoRepository) {
        this.operacaoRepository = operacaoRepository;
    }

    public Operacao salvar(Operacao operacao) {
        return operacaoRepository.save(operacao);
    }

    public List<Operacao> listarTodas() {
        return operacaoRepository.findAll();
    }

    public Optional<Operacao> buscarPorId(Long id) {
        return operacaoRepository.findById(id);
    }
}
