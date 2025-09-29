package com.MensurA.web.features.repeticoes.model;

import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "repeticoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Repeticao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0) @Max(360)
    private Integer anguloInicial;

    @Min(0) @Max(360)
    private Integer anguloFinal;

    @Min(0) @Max(360)
    private Integer excursao;

    @Min(0) @Max(10)
    private Integer dor;

    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mensuracao_id")
    private Mensuracao mensuracao;
}