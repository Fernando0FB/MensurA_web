package com.MensurA.web.commom.exception;

public class MensuracaoNaoEncontradaException extends EntidadeNaoEncontradaException {
    public MensuracaoNaoEncontradaException(Long id) {
      super("Mensuracao com id '" + id + "' não encontrada.");
    }
}
