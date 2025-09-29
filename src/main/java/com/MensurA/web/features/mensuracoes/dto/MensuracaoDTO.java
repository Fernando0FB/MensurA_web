package com.MensurA.web.features.mensuracoes.dto;

import com.MensurA.web.features.mensuracoes.enums.Articulacao;
import com.MensurA.web.features.mensuracoes.enums.Lado;
import com.MensurA.web.features.mensuracoes.enums.Movimento;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.repeticoes.dto.RepeticaoDTO;

import java.util.List;

public record MensuracaoDTO(Long id, Long pacienteId, Articulacao articulacao, Lado lado, Movimento movimento, String posicao, List<RepeticaoDTO> repeticoes) {
    public static MensuracaoDTO from(Mensuracao mensuracao) {
        return new MensuracaoDTO(mensuracao.getId(), mensuracao.getPaciente().getId(), mensuracao.getArticulacao(), mensuracao.getLado(), mensuracao.getMovimento(), mensuracao.getPosicao(), mensuracao.getRepeticoes().stream().map(RepeticaoDTO::from).toList());
    }
}
