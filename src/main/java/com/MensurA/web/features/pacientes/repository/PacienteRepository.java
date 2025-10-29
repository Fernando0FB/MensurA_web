package com.MensurA.web.features.pacientes.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.pacientes.model.Paciente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, JpaSpecificationExecutor<Paciente> {
    Optional<Paciente> findByNome(String nome);
}
