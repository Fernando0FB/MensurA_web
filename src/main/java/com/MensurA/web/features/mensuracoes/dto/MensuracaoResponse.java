package com.MensurA.web.features.mensuracoes.dto;

import com.MensurA.web.commom.enums.Articulacao;
import com.MensurA.web.commom.enums.Lado;
import com.MensurA.web.commom.enums.Movimento;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.repeticoes.dto.RepeticaoDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MensuracaoResponse(
        Long id,
        PacienteMensuracaoDTO pacienteMensuracaoDTO,
        Articulacao articulacao,
        Lado lado,
        Movimento movimento,
        String posicao,
        List<RepeticaoDTO> repeticoes
) {
    public static MensuracaoResponse from(Mensuracao mensuracao) {
        return new MensuracaoResponse(mensuracao.getId(), PacienteMensuracaoDTO.from(mensuracao.getPaciente()), mensuracao.getArticulacao(), mensuracao.getLado(), mensuracao.getMovimento(), mensuracao.getPosicao(), mensuracao.getRepeticoes().stream().map(RepeticaoDTO::from).toList());
    }
}
