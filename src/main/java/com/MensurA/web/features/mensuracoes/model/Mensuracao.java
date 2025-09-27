package com.MensurA.web.features.mensuracoes.model;

import com.MensurA.web.commom.tenancy.TenantField;
import com.MensurA.web.features.mensuracoes.enums.Articulacao;
import com.MensurA.web.features.mensuracoes.enums.Lado;
import com.MensurA.web.features.mensuracoes.enums.Movimento;
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

    @Column(nullable = false)
    @NotNull(message = "O angulo inicial deve ser informado")
    private Integer anguloInicial;

    @Column(nullable = false)
    @NotNull(message = "O angulo final deve ser informado")
    private Integer anguloFinal;

    @Column()
    private Integer amplitude;

    @Min(value = 0)
    @Max(value = 10)
    private Integer dor;

    @Column(length = 500)
    private String limitacao;

    @Column(length = 500)
    private String compensacao;

    @Column(length = 500)
    private String observacoes;

    @Column(nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @TenantField
    @Column(name = "tenant")
    private String tenant;
}
