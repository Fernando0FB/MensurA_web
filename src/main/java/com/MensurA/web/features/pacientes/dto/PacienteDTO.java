package com.MensurA.web.features.pacientes.dto;

import com.MensurA.web.commom.enums.Sexo;
import com.MensurA.web.features.pacientes.model.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PacienteDTO(
        Long id,
        @NotBlank(message = "O nome deve ser informado")
        String nome,
        @NotBlank(message = "O CPF deve ser informado")
        String cpf,
        @NotBlank(message = "O email deve ser informado")
        String email,
        @NotNull(message = "A data de nascimento deve ser informada")
        LocalDate dataNascimento,
        @NotNull(message = "O sexo deve ser informado")
        Sexo sexo,
        Integer quantidadeMensuracoes,
        String observacoes
) {
    public static PacienteDTO from(Paciente p) {
        return new PacienteDTO(p.getId(), p.getNome(),  p.getCpf(), p.getEmail(), p.getDataNascimento(), p.getSexo(), p.getMensuracoes().size(), p.getObservacoes());
    }
}
