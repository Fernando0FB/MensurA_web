package com.MensurA.web.features.repeticoes.model;

import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_repeticoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Repeticao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0) @Max(360)
    @NotNull(message = "O angulo inicial deve ser informado")
    private Integer anguloInicial;

    @Min(0) @Max(360)
    private Integer anguloFinal;

    @Min(0) @Max(360)
    private Integer excursao;

    @Min(0) @Max(10)
    private Integer dor;

    private String observacoes;

    @Column(name = "data_hora_repeticao")
    private LocalDateTime dataHoraRepeticao = LocalDateTime.now();

    @Column(name = "serie", nullable = false)
    @NotNull(message = "A serie deve ser informada")
    private Integer serie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mensuracao_id")
    private Mensuracao mensuracao;
}