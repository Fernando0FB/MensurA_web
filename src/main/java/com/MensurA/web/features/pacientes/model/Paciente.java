package com.MensurA.web.features.pacientes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @NotBlank(message = "A data de nascimento deve ser informada")
    private LocalDate dataNascimento;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "O email deve ser informado")
    private String email;

    @Column(name = "sexo", nullable = false)
    @NotBlank(message = "O sexo deve ser informado")
    private String sexo;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "tenant")
    private String tenant;
}
