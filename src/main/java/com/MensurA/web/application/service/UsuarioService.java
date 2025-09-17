package com.MensurA.web.application.service;

import com.MensurA.web.application.dto.LoginRequest;
import com.MensurA.web.domain.entity.Usuario;
import com.MensurA.web.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public String criar(LoginRequest request) {
        String cpf = request.getCpf();

        usuarioRepository.findByCpf(cpf).ifPresent(u -> {
            throw new IllegalArgumentException("Usuário já existe com esse CPF");
        });

        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setCpf(cpf);
        usuarioRepository.salvar(usuario);

        return "Boa";
    }
}
