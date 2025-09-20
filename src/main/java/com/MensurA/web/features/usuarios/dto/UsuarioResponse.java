package com.MensurA.web.features.usuarios.dto;

import com.MensurA.web.features.usuarios.model.Usuario;

import java.time.LocalDate;


public record UsuarioResponse(Long id, String nome, String login, String email, String telefone, String cpf) {
    public static UsuarioResponse from(Usuario u) { return new UsuarioResponse(u.getId() ,u.getNome() ,u.getLogin() ,u.getEmail() ,u.getTelefone() ,u.getCpf() );}
}
