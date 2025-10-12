package com.MensurA.web.features.mensuracoes.repository;

import com.MensurA.web.features.mensuracoes.dto.MensuracaoDTO;
import com.MensurA.web.features.mensuracoes.dto.MensuracaoResponse;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.pacientes.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MensuracaoRepository extends JpaRepository<Mensuracao, Long>, JpaSpecificationExecutor<Mensuracao> {
    Page<MensuracaoResponse> findAllByPaciente(Paciente paciente, Pageable pageable);
}
