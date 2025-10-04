package com.MensurA.web.features.mensuracoes.dto;

import com.MensurA.web.features.pacientes.model.Paciente;

public record PacienteMensuracaoDTO(Long id, String nome) {
    public static PacienteMensuracaoDTO from(Paciente paciente) {
        return new PacienteMensuracaoDTO(paciente.getId(), paciente.getNome());
    }
}
