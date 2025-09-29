package com.MensurA.web.features.pacientes.dto;

import com.MensurA.web.features.pacientes.model.Paciente;

import java.time.LocalDate;
import java.util.List;

public record PacienteMensuracoesDTO(Long id, String nome, String email, LocalDate dataNascimento, String sexo, String observacoes, List<MensuracaoDTO> mensuracoes) {
    public static PacienteMensuracoesDTO from(Paciente p) {
        return new PacienteMensuracoesDTO(p.getId(), p.getNome(), p.getEmail(), p.getDataNascimento(), p.getSexo(), p.getObservacoes(), p.getMensuracoes().stream().map(MensuracaoDTO::from).toList());
    }
}
