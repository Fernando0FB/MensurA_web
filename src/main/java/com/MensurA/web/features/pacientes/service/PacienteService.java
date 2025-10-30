package com.MensurA.web.features.pacientes.service;

import com.MensurA.web.commom.exception.PacienteNaoEncontradoException;
import com.MensurA.web.features.pacientes.dto.PacienteDTO;
import com.MensurA.web.features.pacientes.model.Paciente;
import com.MensurA.web.features.pacientes.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.MensurA.web.features.pacientes.model.PacienteSpecs.*;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;


    @Transactional(readOnly = true)
    public PacienteDTO getPaciente(Long id) {
        return pacienteRepository.findById(id)
                .map(PacienteDTO::from)
                .orElseThrow(() -> new PacienteNaoEncontradoException(id));
    }

    @Transactional
    public Page<PacienteDTO> buscarFiltrado(String pacienteNome, String cpf, Pageable pageable) {
        Specification<Paciente> spec = Specification
                .where(hasCpf(cpf))
                .and(hasNome(pacienteNome));

        return pacienteRepository.findAll(spec, pageable)
                .map(PacienteDTO::from);
    }

    @Transactional
    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.nome());
        paciente.setCpf(pacienteDTO.cpf());
        paciente.setDataNascimento(pacienteDTO.dataNascimento());
        paciente.setEmail(pacienteDTO.email());
        paciente.setSexo(pacienteDTO.sexo());
        paciente.setObservacoes(pacienteDTO.observacoes());
        return PacienteDTO.from(pacienteRepository.save(paciente));
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.findById(id).map(mensuracao -> {
            pacienteRepository.delete(mensuracao);
            return true;
        }).orElseThrow(() -> new PacienteNaoEncontradoException(id));
    }
}
