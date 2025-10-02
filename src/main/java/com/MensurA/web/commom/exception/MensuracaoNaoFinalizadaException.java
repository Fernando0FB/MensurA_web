package com.MensurA.web.commom.exception;

public class MensuracaoNaoFinalizadaException extends RuntimeException {
    public MensuracaoNaoFinalizadaException(Long id) {
        super("Não foram encontradas repetições para a mensuração de id " + id);
    }
}
