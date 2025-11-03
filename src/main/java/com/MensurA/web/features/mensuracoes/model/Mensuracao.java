package com.MensurA.web.features.mensuracoes.model;

import com.MensurA.web.commom.tenancy.TenantField;
import com.MensurA.web.commom.enums.Articulacao;
import com.MensurA.web.commom.enums.Lado;
import com.MensurA.web.commom.enums.Movimento;
import com.MensurA.web.features.pacientes.model.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_mensuracoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Filter(name = "tenantFilter", condition = "tenant = :tenant")
public class Mensuracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Articulacao articulacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Lado lado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Movimento movimento;

    private String posicao;

    @Min(0) @Max(360)
    @NotNull(message = "O angulo inicial deve ser informado")
    private Integer anguloInicial;

    @Min(0) @Max(360)
    @NotNull(message = "O angulo final deve ser informado")
    private Integer anguloFinal;

    @Min(0) @Max(360)
    private Integer excursao;

    @Min(0) @Max(10)
    private Integer dor;

    private String observacoes;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @TenantField
    @Column(name = "tenant")
    private String tenant;
}
