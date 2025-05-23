package com.conf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeriodoTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data; // formato: yyyy-MM-dd
    private String inicio; // HH:mm
    private String fim;

    private String chefe;
    private String planista1;
    private String planista2;
    private String porao;
    private String balanca;
    private String guindaste;

    @ManyToOne
    @JoinColumn(name = "operacao_id")
    @JsonIgnore
    private Operacao operacao;
}
