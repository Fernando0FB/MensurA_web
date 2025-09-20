package com.MensurA.web.commom.exception;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException(String login) {
        super("Senha inválida para o usuário: " + login);
    }
}
