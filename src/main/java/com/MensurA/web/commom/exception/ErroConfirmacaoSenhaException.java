package com.MensurA.web.commom.exception;

public class ErroConfirmacaoSenhaException extends RuntimeException {
    public ErroConfirmacaoSenhaException() {
        super("As senhas não conferem.");
    }
}
