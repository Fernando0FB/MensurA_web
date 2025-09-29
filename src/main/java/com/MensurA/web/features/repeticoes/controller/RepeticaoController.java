package com.MensurA.web.features.repeticoes.controller;

import com.MensurA.web.features.repeticoes.dto.RepeticaoDTO;
import com.MensurA.web.features.repeticoes.service.RepeticaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repeticoes")
@RequiredArgsConstructor
public class RepeticaoController {

    private final RepeticaoService repeticaoService;

    @GetMapping
    public ResponseEntity<Page<RepeticaoDTO>> listarRepeticoes(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(repeticaoService.listarTodasRepeticoes(pageable));
    }

    @GetMapping("/mensuracao/{id}")
    public ResponseEntity<Page<RepeticaoDTO>> getRepeticaoByMensuracao(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @PathVariable Long id) {
        return ResponseEntity.ok(repeticaoService.listarRepeticoesByMensuracao(pageable, id));
    }

    @PostMapping
    public ResponseEntity<RepeticaoDTO> criarRepeticao(@RequestBody RepeticaoDTO repeticaoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repeticaoService.criarRepeticao(repeticaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repeticaoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepeticaoDTO> getRepeticao(@PathVariable Long id) {
        return ResponseEntity.ok(repeticaoService.getRepeticao(id));
    }
}
