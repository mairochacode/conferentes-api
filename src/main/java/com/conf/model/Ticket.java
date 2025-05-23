package com.conf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guindaste;
    private String porao;
    private String deck;
    private String posicao;
    private String produto;
    private String destino;
    private String placa;

    private double tara;
    private double pesoCaminhao;
    private double pesoLiquido;

    private LocalDateTime dataHora;

    private String terno; // Ex: "1º"

    @ManyToOne
    @JoinColumn(name = "operacao_id")
    @JsonIgnore // <- evita o loop
    private Operacao operacao;
}
