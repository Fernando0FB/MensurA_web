package com.MensurA.web.features.pacientes.controller;

import com.MensurA.web.features.pacientes.dto.PacienteDTO;
import com.MensurA.web.features.pacientes.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> list(@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PacienteDTO> pacientes = pacienteService.listPacientes(pageable);
        return ResponseEntity.status(pacientes.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPaciente(@PathVariable Long id) {
        PacienteDTO paciente = pacienteService.getPaciente(id);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public PacienteDTO cadastrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.criarPaciente(pacienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.ok("Paciente de id " + id + " removida com sucesso!");
    }
}
