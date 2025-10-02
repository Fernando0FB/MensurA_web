package com.MensurA.web.features.usuarios.dto;

import com.MensurA.web.features.usuarios.model.Usuario;

public record UsuarioRequest(String nome, String login, String senha, String email, String telefone, String cpf) {
    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setCpf(cpf);
        return usuario;
    }
}