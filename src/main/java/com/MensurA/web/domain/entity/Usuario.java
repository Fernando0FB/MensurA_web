package com.MensurA.web.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "O email deve ser informado")
    private String email;

    @Column(name = "cpf", nullable = false)
    @Size(max = 11, message = "O CPF informado não pode conter mais de {max} caracteres")
    @NotBlank(message = "O CPF deve ser informado")
    private String cpf;
}