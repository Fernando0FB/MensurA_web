package com.MensurA.web.commom.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String usuario) {
        super("Usuário com login '" + usuario + "' não encontrado.");
    }
}
