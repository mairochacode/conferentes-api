package com.conf.controller;

import com.conf.model.Operacao;
import com.conf.model.Ticket;
import com.conf.service.OperacaoService;
import com.conf.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/operacoes/{operacaoId}/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    private final TicketService ticketService;
    private final OperacaoService operacaoService;

    public TicketController(TicketService ticketService, OperacaoService operacaoService) {
        this.ticketService = ticketService;
        this.operacaoService = operacaoService;
    }

    @PostMapping
    public ResponseEntity<Ticket> criar(
            @PathVariable Long operacaoId,
            @RequestBody Ticket ticket
    ) {
        return operacaoService.buscarPorId(operacaoId)
                .map(operacao -> {
                    ticket.setOperacao(operacao);
                    ticket.setDataHora(LocalDateTime.now());
                    double liquido = ticket.getPesoCaminhao() - ticket.getTara();
                    ticket.setPesoLiquido(liquido);
                    return ResponseEntity.ok(ticketService.salvar(ticket));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> listarPorOperacao(@PathVariable Long operacaoId) {
        return ResponseEntity.ok(ticketService.listarPorOperacao(operacaoId));
    }
}
