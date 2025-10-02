package com.MensurA.web.commom.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {
    public UsuarioNaoEncontradoException(String usuario) {
        super("Usuário com login '" + usuario + "' não encontrado.");
    }
}
