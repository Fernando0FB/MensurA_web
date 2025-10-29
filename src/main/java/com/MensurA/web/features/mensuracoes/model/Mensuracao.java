package com.MensurA.web.features.mensuracoes.model;

import com.MensurA.web.commom.tenancy.TenantField;
import com.MensurA.web.commom.enums.Articulacao;
import com.MensurA.web.commom.enums.Lado;
import com.MensurA.web.commom.enums.Movimento;
import com.MensurA.web.features.pacientes.model.Paciente;
import com.MensurA.web.features.repeticoes.model.Repeticao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;

import java.util.List;

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

    @OneToMany(mappedBy = "mensuracao", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Repeticao> repeticoes;

    @TenantField
    @Column(name = "tenant")
    private String tenant;
}
