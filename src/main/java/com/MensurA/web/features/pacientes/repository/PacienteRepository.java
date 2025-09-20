package com.MensurA.web.features.pacientes.repository;

import com.MensurA.web.features.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNome(String nome);
}
