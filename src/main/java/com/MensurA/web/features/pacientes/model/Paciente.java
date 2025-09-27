package com.MensurA.web.features.pacientes.model;

import com.MensurA.web.commom.tenancy.TenantField;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Filter(name = "tenantFilter", condition = "tenant = :tenant")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull(message = "A data de nascimento deve ser informada")
    private LocalDate dataNascimento;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "O email deve ser informado")
    private String email;

    @Column(name = "sexo", nullable = false)
    @NotBlank(message = "O sexo deve ser informado")
    private String sexo;

    @Column(name = "observacoes")
    private String observacoes;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mensuracao> mensuracoes = new ArrayList<>();

    @TenantField
    @Column(name = "tenant")
    private String tenant;
}
