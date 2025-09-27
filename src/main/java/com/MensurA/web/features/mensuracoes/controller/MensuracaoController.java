package com.MensurA.web.features.mensuracoes.controller;

import com.MensurA.web.features.mensuracoes.dto.MensuracaoDTO;
import com.MensurA.web.features.mensuracoes.service.MensuracaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mensuracoes")
@RequiredArgsConstructor
public class MensuracaoController {

    private final MensuracaoService mensuracaoService;

    @GetMapping
    public Page<MensuracaoDTO> list(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return mensuracaoService.listarMensuracoes(pageable);
    }

    @GetMapping("/paciente/{pacienteId}")
    public Page<MensuracaoDTO> listPacienteMensuracoes(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @PathVariable Long pacienteId) {
        return mensuracaoService.listarMensuracoesPorPaciente(pacienteId, pageable);
    }

    @PostMapping
    public MensuracaoDTO cadastrarMensuracao(@RequestBody MensuracaoDTO mensuracaoDTO) {
        return mensuracaoService.cadastrarMensuracao(mensuracaoDTO);
    }
}
