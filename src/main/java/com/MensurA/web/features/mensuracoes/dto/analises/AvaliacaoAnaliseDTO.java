package com.MensurA.web.features.mensuracoes.dto.analises;

import com.MensurA.web.commom.enums.Articulacao;
import com.MensurA.web.commom.enums.Lado;
import com.MensurA.web.commom.enums.Movimento;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;

public record AvaliacaoAnaliseDTO(
        Articulacao articulacao,
        Lado lado,
        Movimento movimento,
        String posicao,
        Integer anguloInicial,
        Integer anguloFinal,
        Integer excursao,
        Integer dor,
        String observacao
) {
    public static AvaliacaoAnaliseDTO from(Mensuracao mensuracao) {
        return new AvaliacaoAnaliseDTO(mensuracao.getArticulacao(), mensuracao.getLado(), mensuracao.getMovimento(), mensuracao.getPosicao(),
                mensuracao.getAnguloInicial(), mensuracao.getAnguloFinal(), mensuracao.getExcursao(), mensuracao.getDor(), mensuracao.getObservacoes());
    }
}
