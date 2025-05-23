package com.conf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String operador;

    private String tipoCarregamento;

    private LocalDate dataChegada;

    private int numeroDecks;

    private int numeroPoroes;

    @OneToMany(mappedBy = "operacao", cascade = CascadeType.ALL)
    private List<Terno> ternos;

}
