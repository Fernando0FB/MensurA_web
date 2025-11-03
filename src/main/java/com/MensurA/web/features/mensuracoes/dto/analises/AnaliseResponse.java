package com.MensurA.web.features.mensuracoes.dto.analises;

public record AnaliseResponse(
        PacienteAnaliseDTO paciente,
        AvaliacaoAnaliseDTO avaliacao,
        String observacoes
) {
}
