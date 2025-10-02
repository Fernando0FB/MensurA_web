package com.MensurA.web.commom.exception;

public abstract class EntidadeNaoEncontradaException extends RuntimeException {
  public EntidadeNaoEncontradaException(String message) {
    super(message);
  }
}