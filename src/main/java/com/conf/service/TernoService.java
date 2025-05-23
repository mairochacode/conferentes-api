package com.conf.service;

import com.conf.model.Terno;
import com.conf.repository.TernoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TernoService {

    private final TernoRepository ternoRepository;

    public TernoService(TernoRepository ternoRepository) {
        this.ternoRepository = ternoRepository;
    }

    public Terno salvar(Terno terno) {
        return ternoRepository.save(terno);
    }

    public List<Terno> listarPorOperacao(Long operacaoId) {
        return ternoRepository.findByOperacaoId(operacaoId);
    }
}
