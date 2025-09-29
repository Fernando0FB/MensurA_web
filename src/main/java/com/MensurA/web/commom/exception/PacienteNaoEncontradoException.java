package com.MensurA.web.commom.exception;

public class PacienteNaoEncontradoException extends RuntimeException {
    public PacienteNaoEncontradoException(Long id) {
        super("Paciente com o ID'" + id + "' não encontrado.");
    }
}
