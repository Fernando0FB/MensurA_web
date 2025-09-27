package com.MensurA.web.features.mensuracoes.service;

import com.MensurA.web.features.mensuracoes.dto.MensuracaoDTO;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.mensuracoes.repository.MensuracaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MensuracaoService {

    private final MensuracaoRepository mensuracaoRepository;

    public Page<MensuracaoDTO> listarMensuracoes(Pageable pageable) {
        return mensuracaoRepository.findAll(pageable).map(MensuracaoDTO::from);
    }

    public Page<MensuracaoDTO> listarMensuracoesPorPaciente(Long pacienteId, Pageable pageable) {
        return mensuracaoRepository.findByPacienteId(pacienteId, pageable).map(MensuracaoDTO::from);
    }

    public MensuracaoDTO cadastrarMensuracao(MensuracaoDTO mensuracaoDTO) {
        Mensuracao mensuracao = new Mensuracao();
        mensuracao.setArticulacao(mensuracaoDTO.articulacao());
        mensuracao.setLado(mensuracaoDTO.lado());
        mensuracao.setMovimento(mensuracaoDTO.movimento());
        mensuracao.setAnguloInicial(mensuracaoDTO.anguloInicial());
        mensuracao.setAnguloFinal(mensuracaoDTO.anguloFinal());
        mensuracao.setAmplitude(mensuracaoDTO.amplitude());
        mensuracao.setDor(mensuracaoDTO.dor());
        mensuracao.setLimitacao(mensuracaoDTO.limitacao());
        mensuracao.setCompensacao(mensuracaoDTO.compensacao());
        mensuracao.setObservacoes(mensuracaoDTO.observacoes());
        return MensuracaoDTO.from(mensuracaoRepository.save(mensuracao));
    }

}
