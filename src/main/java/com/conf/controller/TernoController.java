package com.conf.controller;

import com.conf.model.Operacao;
import com.conf.model.Terno;
import com.conf.service.TernoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operacoes/{operacaoId}/ternos")
@CrossOrigin(origins = "*")
public class TernoController {

    private final TernoService ternoService;

    public TernoController(TernoService ternoService) {
        this.ternoService = ternoService;
    }

    @PostMapping
    public ResponseEntity<Terno> criarTerno(
            @PathVariable Long operacaoId,
            @RequestBody Terno terno
    ) {
        terno.setOperacao(Operacao.builder().id(operacaoId).build());
        return ResponseEntity.ok(ternoService.salvar(terno));
    }

    @GetMapping
    public ResponseEntity<List<Terno>> listarTernos(@PathVariable Long operacaoId) {
        return ResponseEntity.ok(ternoService.listarPorOperacao(operacaoId));
    }
}
