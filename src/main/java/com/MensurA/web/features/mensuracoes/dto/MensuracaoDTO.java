package com.MensurA.web.features.mensuracoes.dto;

import com.MensurA.web.commom.enums.Articulacao;
import com.MensurA.web.commom.enums.Lado;
import com.MensurA.web.commom.enums.Movimento;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.repeticoes.dto.RepeticaoDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MensuracaoDTO(
        Long id,
        @NotNull(message = "O paciente deve ser informado")
        Long pacienteId,
        @NotNull(message = "A articulacao deve ser informada")
        Articulacao articulacao,
        @NotNull(message = "O lado deve ser informado")
        Lado lado,
        @NotNull(message = "O movimento deve ser informado")
        Movimento movimento,
        @NotNull(message = "A posicao deve ser informada")
        String posicao,
        List<RepeticaoDTO> repeticoes
) {
    public static MensuracaoDTO from(Mensuracao mensuracao) {
        return new MensuracaoDTO(mensuracao.getId(), mensuracao.getPaciente().getId(), mensuracao.getArticulacao(), mensuracao.getLado(), mensuracao.getMovimento(), mensuracao.getPosicao(), mensuracao.getRepeticoes().stream().map(RepeticaoDTO::from).toList());
    }
}
