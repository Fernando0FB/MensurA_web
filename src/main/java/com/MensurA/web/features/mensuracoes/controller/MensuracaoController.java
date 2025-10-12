package com.MensurA.web.features.mensuracoes.controller;

import com.MensurA.web.features.mensuracoes.dto.MensuracaoDTO;
import com.MensurA.web.features.mensuracoes.dto.MensuracaoResponse;
import com.MensurA.web.features.mensuracoes.service.MensuracaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mensuracoes")
@RequiredArgsConstructor
public class MensuracaoController {

    private final MensuracaoService mensuracaoService;

    @GetMapping("/{id}")
    public ResponseEntity<MensuracaoResponse> buscarMensuracao(@PathVariable Long id) {
        return ResponseEntity.ok(mensuracaoService.getMensuracao(id));
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Page<MensuracaoResponse>> listarMensuracoesPorPaciente(
            @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(mensuracaoService.listarMensuracoesPorPaciente(pageable, id));
    }

    @GetMapping
    public ResponseEntity<Page<MensuracaoResponse>> listar(
            @RequestParam(required = false) Long pacienteId,
            @RequestParam(required = false) String articulacao,
            @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return ResponseEntity.ok(mensuracaoService.buscarFiltrado(pacienteId, articulacao, pageable));
    }

    @PostMapping
    public MensuracaoDTO criarMensuracao(@Valid @RequestBody MensuracaoDTO mensuracaoDTO) {
        return mensuracaoService.criarMensuracao(mensuracaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMensuracao(@PathVariable Long id) {
        mensuracaoService.deletarMensuracao(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idMensuracao}/analise")
    public ResponseEntity<?> gerarAnaliseMensuracao(@PathVariable Long idMensuracao) {
        return ResponseEntity.ok(mensuracaoService.getAnaliseMensuracao(idMensuracao));
    }
}
