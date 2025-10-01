package com.MensurA.web.features.mensuracoes.dto.analises;

import java.util.List;

public record AnaliseDTO(
        PacienteAnaliseDTO paciente,
        AvaliacaoAnaliseDTO avaliacao,
        ResumoRepeticoesDTO resumoRepeticoes,
        List<String> observacoesClinicas
) {
}
