package com.conf.service;

import com.conf.model.Ticket;
import com.conf.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket salvar(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> listarPorOperacao(Long operacaoId) {
        return ticketRepository.findByOperacaoId(operacaoId);
    }
}
