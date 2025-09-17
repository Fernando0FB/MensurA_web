package com.MensurA.web.infrastructure.repository;

import com.MensurA.web.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositoryJpa extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);
}