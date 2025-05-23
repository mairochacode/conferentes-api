package com.conf.controller;

import com.conf.model.Operacao;
import com.conf.service.OperacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operacoes")
@CrossOrigin(origins = "*")
public class OperacaoController {

    private final OperacaoService operacaoService;

    public OperacaoController(OperacaoService operacaoService) {
        this.operacaoService = operacaoService;
    }

    @PostMapping
    public ResponseEntity<Operacao> criar(@RequestBody Operacao operacao) {
        return ResponseEntity.ok(operacaoService.salvar(operacao));
    }

    @GetMapping
    public ResponseEntity<List<Operacao>> listarTodas() {
        return ResponseEntity.ok(operacaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operacao> buscarPorId(@PathVariable Long id) {
        return operacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
