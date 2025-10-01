package com.MensurA.web.features.repeticoes.dto;

import com.MensurA.web.features.repeticoes.model.Repeticao;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RepeticaoDTO(
        Long id,
        @Min(0) @Max(360)
        @NotNull(message = "O angulo inicial deve ser informado")
        Integer anguloInicial,
        @Min(0) @Max(360)
        @NotNull(message = "O angulo final deve ser informado")
        Integer anguloFinal,
        @Min(0) @Max(360)
        @NotNull(message = "A excursao deve ser informada")
        Integer excursao,
        @Min(0) @Max(10)
        @NotNull(message = "A dor deve ser informado")
        Integer dor,
        @NotNull(message = "A serie deve ser informada")
        Integer serie,
        @NotNull(message = "A data e hora da repeticao deve ser informada")
        LocalDateTime dataHoraRepeticao,
        String observacoes,
        @NotNull(message = "A mensuracao deve ser informada")
        Long mensuracaoId
) {
    public static RepeticaoDTO from(Repeticao r) {
        return new RepeticaoDTO(r.getId(), r.getAnguloInicial(), r.getAnguloFinal(), r.getExcursao(), r.getDor(), r.getSerie(), r.getDataHoraRepeticao(), r.getObservacoes(), r.getMensuracao().getId());
    }
}
