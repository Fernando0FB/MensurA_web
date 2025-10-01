package com.MensurA.web.features.mensuracoes.dto.analises;

import com.MensurA.web.features.repeticoes.model.Repeticao;

import java.util.List;

public record ResumoRepeticoesDTO(
        Double anguloInicialMedio,
        Double anguloFinalMedio,
        Double excursaoMedia,
        Double dorMedia,
        Integer melhorExcursao,
        Integer piorExcursao,
        Integer quantidadeExecucoes
) {
    public static ResumoRepeticoesDTO from(
            List<Repeticao> repeticoes
    ) {
        Double anguloInicialMedio = repeticoes.stream()
                .mapToInt(Repeticao::getAnguloInicial)
                .average()
                .orElse(0);
        Double anguloFinalMedio = repeticoes.stream()
                .mapToInt(Repeticao::getAnguloFinal)
                .average()
                .orElse(0);
        Double excursaoMedia = repeticoes.stream()
                .mapToInt(Repeticao::getExcursao)
                .average()
                .orElse(0);
        Double dorMedia = repeticoes.stream()
                .mapToInt(Repeticao::getDor)
                .average()
                .orElse(0);
        Integer melhorExcursao = repeticoes.stream()
                .mapToInt(Repeticao::getExcursao)
                .max()
                .orElse(0);
        Integer piorExcursao = repeticoes.stream()
                .mapToInt(Repeticao::getExcursao)
                .min()
                .orElse(0);
        return new ResumoRepeticoesDTO(anguloInicialMedio, anguloFinalMedio, excursaoMedia, dorMedia, melhorExcursao, piorExcursao, repeticoes.size());
    }
}
