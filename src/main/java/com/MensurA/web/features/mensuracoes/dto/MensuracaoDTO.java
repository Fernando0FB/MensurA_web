package com.MensurA.web.features.mensuracoes.dto;

import com.MensurA.web.commom.enums.Articulacao;
import com.MensurA.web.commom.enums.Lado;
import com.MensurA.web.commom.enums.Movimento;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
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
        String posicao,
        @Min(0) @Max(360)
        @NotNull(message = "O angulo inicial deve ser informado")
        Integer anguloInicial,
        @Min(0) @Max(360)
        @NotNull(message = "O angulo final deve ser informado")
        Integer anguloFinal,
        @Min(0) @Max(360)
        Integer excursao,
        @Min(0) @Max(10)
        Integer dor,
        String observacoes,
        LocalDateTime dataHora
) {
    public static MensuracaoDTO from(Mensuracao mensuracao) {
        return new MensuracaoDTO(mensuracao.getId(), mensuracao.getPaciente().getId(),
                mensuracao.getArticulacao(), mensuracao.getLado(), mensuracao.getMovimento(),
                mensuracao.getPosicao(), mensuracao.getAnguloInicial(), mensuracao.getAnguloFinal(),
                mensuracao.getExcursao(), mensuracao.getDor(), mensuracao.getObservacoes(), mensuracao.getDataHora());
    }
}
