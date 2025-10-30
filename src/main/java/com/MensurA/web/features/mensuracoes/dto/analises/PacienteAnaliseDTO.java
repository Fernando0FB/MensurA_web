package com.MensurA.web.features.mensuracoes.dto.analises;

import com.MensurA.web.commom.enums.Sexo;
import com.MensurA.web.features.pacientes.model.Paciente;

public record PacienteAnaliseDTO(String nome, Sexo sexo, String cpf) {
    public static PacienteAnaliseDTO from(Paciente paciente) {
        return new PacienteAnaliseDTO(paciente.getNome(), paciente.getSexo(), paciente.getCpf());
    }
}
