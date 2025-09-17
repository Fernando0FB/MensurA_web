package com.MensurA.web.domain.repository;

import com.MensurA.web.domain.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findByCpf(String cpf);
    Usuario salvar(Usuario usuario);
}