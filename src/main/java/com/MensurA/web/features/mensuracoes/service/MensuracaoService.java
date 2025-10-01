package com.MensurA.web.features.mensuracoes.service;

import com.MensurA.web.commom.exception.MensuracaoNaoEncontradaException;
import com.MensurA.web.commom.exception.MensuracaoNaoFinalizadaException;
import com.MensurA.web.commom.exception.PacienteNaoEncontradoException;
import com.MensurA.web.features.mensuracoes.dto.MensuracaoDTO;
import com.MensurA.web.features.mensuracoes.dto.analises.AnaliseDTO;
import com.MensurA.web.features.mensuracoes.dto.analises.AvaliacaoAnaliseDTO;
import com.MensurA.web.features.mensuracoes.dto.analises.PacienteAnaliseDTO;
import com.MensurA.web.features.mensuracoes.dto.analises.ResumoRepeticoesDTO;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.mensuracoes.repository.MensuracaoRepository;
import com.MensurA.web.features.pacientes.model.Paciente;
import com.MensurA.web.features.pacientes.repository.PacienteRepository;
import com.MensurA.web.features.repeticoes.model.Repeticao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MensuracaoService {

    private final MensuracaoRepository mensuracaoRepository;
    private final PacienteRepository pacienteRepository;

    public Page<MensuracaoDTO> listarMensuracoes(Pageable pageable) {
        return mensuracaoRepository.findAll(pageable).map(MensuracaoDTO::from);
    }

    public Page<MensuracaoDTO> listarMensuracoesPorPaciente(Pageable pageable, Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() ->
                new PacienteNaoEncontradoException(pacienteId)
        );
        return mensuracaoRepository.findAllByPaciente(paciente, pageable);
    }

    public MensuracaoDTO criarMensuracao(MensuracaoDTO mensuracaoDTO) {
        Mensuracao mensuracao = new Mensuracao();
        mensuracao.setPaciente(pacienteRepository.findById(mensuracaoDTO.pacienteId()).orElseThrow(() -> new PacienteNaoEncontradoException(mensuracaoDTO.pacienteId())));
        mensuracao.setArticulacao(mensuracaoDTO.articulacao());
        mensuracao.setLado(mensuracaoDTO.lado());
        mensuracao.setPosicao(mensuracaoDTO.posicao());
        mensuracao.setMovimento(mensuracaoDTO.movimento());
        mensuracao.setRepeticoes(mensuracaoDTO.repeticoes() != null ? mensuracaoDTO.repeticoes().stream().map(repeticaoDTO -> {
            Repeticao repeticao = new Repeticao();
            repeticao.setDor(repeticaoDTO.dor());
            repeticao.setObservacoes(repeticaoDTO.observacoes());
            repeticao.setExcursao(repeticaoDTO.excursao());
            repeticao.setAnguloInicial(repeticaoDTO.anguloInicial());
            repeticao.setAnguloFinal(repeticaoDTO.anguloFinal());
            repeticao.setMensuracao(mensuracao);
            return repeticao;
        }).toList() : new ArrayList<>());

        return MensuracaoDTO.from(mensuracaoRepository.save(mensuracao));
    }

    public void deletarMensuracao(Long id) {
        mensuracaoRepository.findById(id).map(mensuracao -> {
            mensuracaoRepository.delete(mensuracao);
            return true;
        }).orElseThrow(() -> new MensuracaoNaoEncontradaException(id));
    }

    public MensuracaoDTO getMensuracao(Long id) {
        return mensuracaoRepository.findById(id)
                .map(MensuracaoDTO::from)
                .orElseThrow(() -> new MensuracaoNaoEncontradaException(id));
    }

    public AnaliseDTO getAnaliseMensuracao(Long idMensuracao) {
        Mensuracao mensuracao = mensuracaoRepository.findById(idMensuracao)
                .orElseThrow(() -> new MensuracaoNaoEncontradaException(idMensuracao));

        if (mensuracao.getRepeticoes().isEmpty()) {
            throw new MensuracaoNaoFinalizadaException(idMensuracao);
        }

        PacienteAnaliseDTO pacienteAnaliseDTO = PacienteAnaliseDTO.from(mensuracao.getPaciente());
        AvaliacaoAnaliseDTO avaliacaoAnaliseDTO = AvaliacaoAnaliseDTO.from(mensuracao);
        ResumoRepeticoesDTO resumoRepeticoesDTO = ResumoRepeticoesDTO.from(mensuracao.getRepeticoes());
        List<String> observacoesClinicas = mensuracao.getRepeticoes().stream().map(Repeticao::getObservacoes).toList();

        return new AnaliseDTO(pacienteAnaliseDTO, avaliacaoAnaliseDTO, resumoRepeticoesDTO, observacoesClinicas);
    }
}
