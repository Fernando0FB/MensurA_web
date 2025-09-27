package com.MensurA.web.features.mensuracoes.repository;

import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensuracaoRepository extends JpaRepository<Mensuracao, Long> {
    Page<Mensuracao> findByPacienteId(Long pacienteId, Pageable pageable);
    Page<Mensuracao> findAll(Pageable pageable);
}
