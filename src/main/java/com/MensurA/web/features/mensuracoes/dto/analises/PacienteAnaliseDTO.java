package com.MensurA.web.features.mensuracoes.dto.analises;

import com.MensurA.web.commom.enums.Sexo;
import com.MensurA.web.features.pacientes.model.Paciente;

public record PacienteAnaliseDTO(String nome, Integer idade, Sexo sexo, String cpf) {
    public static PacienteAnaliseDTO from(Paciente paciente) {
        return new PacienteAnaliseDTO(paciente.getNome(), paciente.getIdade(), paciente.getSexo(), paciente.getCpf());
    }
}
