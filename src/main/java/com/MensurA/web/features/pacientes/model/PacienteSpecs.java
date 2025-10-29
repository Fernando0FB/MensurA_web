package com.MensurA.web.features.pacientes.model;

import org.springframework.data.jpa.domain.Specification;

public class PacienteSpecs {
    private PacienteSpecs() {}

    public static Specification<Paciente> hasNome(String nome) {
        return (root, cq, cb) -> (nome == null || nome.trim().isEmpty())
                ? null
                : cb.like(cb.upper(root.get("nome")), nome.trim().toUpperCase() + "%");
    }

    public static Specification<Paciente> hasCpf(String cpf) {
        return (root, cq, cb) -> (cpf == null || cpf.trim().isEmpty())
                ? null
                : cb.like(cb.upper(root.get("cpf")),  cpf.trim().toUpperCase() + "%");
    }
}
