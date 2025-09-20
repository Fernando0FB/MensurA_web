package com.MensurA.web.features.usuarios.controller;

import com.MensurA.web.features.usuarios.dto.LoginRequest;
import com.MensurA.web.features.usuarios.dto.UsuarioRequest;
import com.MensurA.web.features.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.login(loginRequest));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioRequest usuarioReq) {
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioReq));
    }
}