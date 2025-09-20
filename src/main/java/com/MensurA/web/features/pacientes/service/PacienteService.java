package com.MensurA.web.features.pacientes.service;

import com.MensurA.web.features.pacientes.dto.PacienteDTO;
import com.MensurA.web.features.pacientes.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Transactional
    public Page<PacienteDTO> listPacientes(Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(PacienteDTO::from);
    }


}
