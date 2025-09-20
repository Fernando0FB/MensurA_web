package com.MensurA.web.features.pacientes.dto;

import com.MensurA.web.features.pacientes.model.Paciente;

public record PacienteDTO(Long id, String nome, String email) {
    public static PacienteDTO from(Paciente p) { return new PacienteDTO(p.getId(), p.getNome(), p.getEmail()); }
}
