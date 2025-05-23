package com.conf.controller;

import com.conf.model.Operacao;
import com.conf.model.PeriodoTrabalho;
import com.conf.service.OperacaoService;
import com.conf.service.PeriodoTrabalhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operacoes/{operacaoId}/periodos")
@CrossOrigin(origins = "*")
public class PeriodoTrabalhoController {

    private final PeriodoTrabalhoService periodoService;
    private final OperacaoService operacaoService;

    public PeriodoTrabalhoController(PeriodoTrabalhoService periodoService, OperacaoService operacaoService) {
        this.periodoService = periodoService;
        this.operacaoService = operacaoService;
    }

    @PostMapping
    public ResponseEntity<PeriodoTrabalho> criar(
            @PathVariable Long operacaoId,
            @RequestBody PeriodoTrabalho periodo
    ) {
        return operacaoService.buscarPorId(operacaoId)
                .map(operacao -> {
                    periodo.setOperacao(operacao);
                    return ResponseEntity.ok(periodoService.salvar(periodo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PeriodoTrabalho>> listar(@PathVariable Long operacaoId) {
        return ResponseEntity.ok(periodoService.listarPorOperacao(operacaoId));
    }
}
