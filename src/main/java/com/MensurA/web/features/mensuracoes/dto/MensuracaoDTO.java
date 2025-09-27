package com.MensurA.web.features.mensuracoes.dto;

import com.MensurA.web.features.mensuracoes.enums.Articulacao;
import com.MensurA.web.features.mensuracoes.enums.Lado;
import com.MensurA.web.features.mensuracoes.enums.Movimento;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;

import java.time.LocalDateTime;

public record MensuracaoDTO(Long id, Articulacao articulacao, Lado lado, Movimento movimento, Integer anguloInicial, Integer anguloFinal, Integer amplitude, Integer dor, String limitacao, String compensacao, String observacoes, LocalDateTime dataHora) {
    public static MensuracaoDTO from(Mensuracao mensuracao) {
        return new MensuracaoDTO(mensuracao.getId(), mensuracao.getArticulacao(), mensuracao.getLado(), mensuracao.getMovimento(), mensuracao.getAnguloInicial(), mensuracao.getAnguloFinal(), mensuracao.getAmplitude(), mensuracao.getDor(), mensuracao.getLimitacao(), mensuracao.getCompensacao(), mensuracao.getObservacoes(), mensuracao.getDataHora());
    }
}
