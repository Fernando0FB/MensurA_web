package com.MensurA.web.features.repeticoes.repository;

import com.MensurA.web.features.repeticoes.model.Repeticao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepeticaoRepository extends JpaRepository<Repeticao, Long> {
    Page<Repeticao> findAllByMensuracao_Id(Pageable pageable, Long mensuracaoId);
}
