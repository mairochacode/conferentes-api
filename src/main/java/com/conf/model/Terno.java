package com.conf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Terno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero; // Pode ser "1º", "2º", "A", "B", etc.

    @ManyToOne
    @JoinColumn(name = "operacao_id")
    private Operacao operacao;
}
