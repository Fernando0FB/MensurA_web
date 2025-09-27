package com.MensurA.web.features.pacientes.service;

import com.MensurA.web.features.pacientes.dto.PacienteDTO;
import com.MensurA.web.features.pacientes.dto.PacienteMensuracoesDTO;
import com.MensurA.web.features.pacientes.model.Paciente;
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

    @Transactional(readOnly = true)
    public Page<PacienteDTO> listPacientes(Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(PacienteDTO::from);
    }

    @Transactional
    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.nome());
        paciente.setSexo(pacienteDTO.sexo());
        paciente.setObservacoes(pacienteDTO.observacoes());
        paciente.setEmail(pacienteDTO.email());
        paciente.setDataNascimento(pacienteDTO.dataNascimento());
        return PacienteDTO.from(pacienteRepository.save(paciente));
    }

    @Transactional(readOnly = true)
    public PacienteMensuracoesDTO listarPacienteComMensuracoes(Long id) {
        return PacienteMensuracoesDTO.from(pacienteRepository.findById(id).orElseThrow());
    }
}
