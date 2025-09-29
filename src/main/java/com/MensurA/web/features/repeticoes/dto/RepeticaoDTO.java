package com.MensurA.web.features.repeticoes.dto;

import com.MensurA.web.features.repeticoes.model.Repeticao;

public record RepeticaoDTO(Long id, Integer anguloInicial, Integer anguloFinal, Integer excursao, Integer dor, String observacoes, Long mensuracaoId) {
    public static RepeticaoDTO from(Repeticao r) {
        return new RepeticaoDTO(r.getId(), r.getAnguloInicial(), r.getAnguloFinal(), r.getExcursao(), r.getDor(), r.getObservacoes(), r.getMensuracao().getId());
    }
}
