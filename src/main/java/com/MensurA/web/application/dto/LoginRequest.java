package com.MensurA.web.application.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String nome;
    private String cpf;
}