package com.MensurA.web.features.mensuracoes.service;

import com.MensurA.web.commom.exception.MensuracaoNaoEncontradaException;
import com.MensurA.web.commom.exception.PacienteNaoEncontradoException;
import com.MensurA.web.features.mensuracoes.dto.MensuracaoDTO;
import com.MensurA.web.features.mensuracoes.dto.MensuracaoResponse;
import com.MensurA.web.features.mensuracoes.dto.analises.AnaliseResponse;
import com.MensurA.web.features.mensuracoes.dto.analises.AvaliacaoAnaliseDTO;
import com.MensurA.web.features.mensuracoes.dto.analises.PacienteAnaliseDTO;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.mensuracoes.repository.MensuracaoRepository;
import com.MensurA.web.features.pacientes.model.Paciente;
import com.MensurA.web.features.pacientes.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.MensurA.web.features.mensuracoes.model.MensuracaoSpecs.*;

@Service
@RequiredArgsConstructor
public class MensuracaoService {

    private final MensuracaoRepository mensuracaoRepository;
    private final PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    public Page<MensuracaoResponse> buscarFiltrado(Long pacienteId, String valorBusca, Pageable pageable) {
        Specification<Mensuracao> spec = Specification
                .where(hasPacienteId(pacienteId))
                .or(hasNome(valorBusca))
                .or(hasArticulacao(valorBusca));

        return mensuracaoRepository.findAll(spec, pageable)
                .map(MensuracaoResponse::from);
    }

    @Transactional(readOnly = true)
    public Page<MensuracaoResponse> listarMensuracoesPorPaciente(Pageable pageable, Long pacienteId) {
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
        mensuracao.setAnguloInicial(mensuracaoDTO.anguloInicial());
        mensuracao.setAnguloFinal(mensuracaoDTO.anguloFinal());
        mensuracao.setExcursao(mensuracaoDTO.excursao());
        mensuracao.setDor(mensuracaoDTO.dor());
        mensuracao.setObservacoes(mensuracaoDTO.observacoes());
        mensuracao.setDataHora(mensuracaoDTO.dataHora() != null ? mensuracaoDTO.dataHora() : LocalDateTime.now());

        return MensuracaoDTO.from(mensuracaoRepository.save(mensuracao));
    }

    public void deletarMensuracao(Long id) {
        mensuracaoRepository.findById(id).map(mensuracao -> {
            mensuracaoRepository.delete(mensuracao);
            return true;
        }).orElseThrow(() -> new MensuracaoNaoEncontradaException(id));
    }

    @Transactional(readOnly = true)
    public MensuracaoResponse getMensuracao(Long id) {
        return mensuracaoRepository.findById(id)
                .map(MensuracaoResponse::from)
                .orElseThrow(() -> new MensuracaoNaoEncontradaException(id));
    }

    @Transactional(readOnly = true)
    public AnaliseResponse getAnaliseMensuracao(Long idMensuracao) {
        Mensuracao mensuracao = mensuracaoRepository.findById(idMensuracao)
                .orElseThrow(() -> new MensuracaoNaoEncontradaException(idMensuracao));

        PacienteAnaliseDTO pacienteAnaliseDTO = PacienteAnaliseDTO.from(mensuracao.getPaciente());
        AvaliacaoAnaliseDTO avaliacaoAnaliseDTO = AvaliacaoAnaliseDTO.from(mensuracao);

        return new AnaliseResponse(pacienteAnaliseDTO, avaliacaoAnaliseDTO, mensuracao.getObservacoes());
    }
}
