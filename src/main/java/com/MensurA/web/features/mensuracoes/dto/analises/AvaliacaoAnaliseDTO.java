package com.MensurA.web.features.mensuracoes.dto.analises;

import com.MensurA.web.commom.enums.Articulacao;
import com.MensurA.web.commom.enums.Lado;
import com.MensurA.web.commom.enums.Movimento;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;

import java.time.LocalDateTime;

public record AvaliacaoAnaliseDTO(
        Articulacao articulacao,
        Lado lado,
        Movimento movimento,
        String posicao,
        Integer anguloInicial,
        Integer anguloFinal,
        Integer excursao,
        Integer dor,
        LocalDateTime dataHora,
        String observacao
) {
    public static AvaliacaoAnaliseDTO from(Mensuracao mensuracao) {
        return new AvaliacaoAnaliseDTO(mensuracao.getArticulacao(), mensuracao.getLado(), mensuracao.getMovimento(), mensuracao.getPosicao(),
                mensuracao.getAnguloInicial(), mensuracao.getAnguloFinal(), mensuracao.getExcursao(), mensuracao.getDor(), mensuracao.getDataHora(), mensuracao.getObservacoes());
    }
}
