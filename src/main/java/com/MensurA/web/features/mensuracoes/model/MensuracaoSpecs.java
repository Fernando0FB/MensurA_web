package com.MensurA.web.features.mensuracoes.model;

import org.springframework.data.jpa.domain.Specification;

public final class MensuracaoSpecs {
    private MensuracaoSpecs() {}

    public static Specification<Mensuracao> hasPacienteId(Long pacienteId) {
        return (root, cq, cb) -> pacienteId == null
                ? null
                : cb.equal(root.get("paciente").get("id"), pacienteId); // ajuste o caminho se for diferente
    }

    public static Specification<Mensuracao> hasNome(String nome) {
        return (root, cq, cb) -> (nome == null || nome.trim().isEmpty())
                ? null
                : cb.like(cb.upper(root.get("paciente").get("nome")), nome.trim().toUpperCase() + "%");
    }

    public static Specification<Mensuracao> hasArticulacao(String articulacao) {
        return (root, cq, cb) -> (articulacao == null || articulacao.trim().isEmpty())
                ? null
                : cb.like(cb.upper(root.get("articulacao")), "%" + articulacao.trim().toUpperCase() + "%");
    }
}