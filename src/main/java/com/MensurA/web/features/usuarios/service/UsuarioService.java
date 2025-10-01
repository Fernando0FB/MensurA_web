package com.MensurA.web.features.usuarios.service;

import com.MensurA.web.commom.exception.SenhaInvalidaException;
import com.MensurA.web.commom.exception.UsuarioNaoEncontradoException;
import com.MensurA.web.commom.security.JwtUtil;
import com.MensurA.web.features.usuarios.dto.LoginRequest;
import com.MensurA.web.features.usuarios.dto.LoginResponse;
import com.MensurA.web.features.usuarios.dto.UsuarioRequest;
import com.MensurA.web.features.usuarios.dto.UsuarioResponse;
import com.MensurA.web.features.usuarios.model.Usuario;
import com.MensurA.web.features.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) {
        Usuario usuario = usuarioRepository.findByLogin(loginRequest.login().toLowerCase())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(loginRequest.login()));

        if (!passwordEncoder.matches(loginRequest.senha(), usuario.getSenha())) {
            throw new SenhaInvalidaException(loginRequest.login());
        }

        return new LoginResponse(jwtUtil.generateToken(usuario));
    }

    public UsuarioResponse cadastrarUsuario(UsuarioRequest usuarioReq) {
        Usuario usuario = usuarioReq.toEntity();
        usuario.setLogin(usuarioReq.login().toLowerCase());
        usuario.setSenha(passwordEncoder.encode(usuarioReq.senha()));
        return UsuarioResponse.from(usuarioRepository.save(usuario));
    }

    public List<UsuarioResponse> findAll() {
        return usuarioRepository.findAll().stream().map(UsuarioResponse::from).toList();
    }
}
