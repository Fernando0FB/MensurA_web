package com.MensurA.web.features.mensuracoes.repository;

import com.MensurA.web.features.mensuracoes.dto.MensuracaoDTO;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.pacientes.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensuracaoRepository extends JpaRepository<Mensuracao, Long> {
    Page<MensuracaoDTO> findAllByPaciente(Paciente paciente, Pageable pageable);
}
