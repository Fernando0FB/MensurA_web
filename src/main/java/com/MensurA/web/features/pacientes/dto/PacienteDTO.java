package com.MensurA.web.features.pacientes.dto;

import com.MensurA.web.features.pacientes.model.Paciente;

import java.time.LocalDate;

public record PacienteDTO(Long id, String nome, String email, LocalDate dataNascimento, String sexo, String observacoes) {
    public static PacienteDTO from(Paciente p) {
        return new PacienteDTO(p.getId(), p.getNome(), p.getEmail(), p.getDataNascimento(), p.getSexo(), p.getObservacoes());
    }

    public static PacienteDTO to(Paciente p) {
        return new PacienteDTO(p.getId(), p.getNome(), p.getEmail(), p.getDataNascimento(), p.getSexo(), p.getObservacoes());
    }
}
