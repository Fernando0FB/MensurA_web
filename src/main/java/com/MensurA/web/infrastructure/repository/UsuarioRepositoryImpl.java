package com.MensurA.web.infrastructure.repository;

import com.MensurA.web.domain.entity.Usuario;
import com.MensurA.web.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    public UsuarioRepositoryImpl(UsuarioRepositoryJpa usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }

    @Override
    public Optional<Usuario> findByCpf(String cpf) {
        return usuarioRepositoryJpa.findByCpf(cpf);
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepositoryJpa.save(usuario);
    }
}
