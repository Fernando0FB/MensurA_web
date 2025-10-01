package com.MensurA.web.commom.exception;

public class RepeticaoNaoEncontradaException extends EntidadeNaoEncontradaException {
    public RepeticaoNaoEncontradaException(Long id) {
        super("Repetição com o '" + id + "' não encontrado.");
    }
}
