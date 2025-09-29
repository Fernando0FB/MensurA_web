package com.MensurA.web.commom.exception;

public class MensuracaoNaoEncontradaException extends RuntimeException {
    public MensuracaoNaoEncontradaException(Long id) {
      super("Mensuracao com id '" + id + "' não encontrada.");
    }
}
