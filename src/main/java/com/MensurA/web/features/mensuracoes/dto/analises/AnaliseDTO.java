package com.MensurA.web.features.mensuracoes.dto.analises;

public record AnaliseDTO(
        PacienteAnaliseDTO paciente,
        AvaliacaoAnaliseDTO avaliacao,
        String observacoes
) {
}
