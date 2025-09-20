package com.MensurA.web.features.teste;

import com.MensurA.web.commom.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teste")
@RequiredArgsConstructor
public class testeController {

    private final JwtUtil jwtUtil;

}
