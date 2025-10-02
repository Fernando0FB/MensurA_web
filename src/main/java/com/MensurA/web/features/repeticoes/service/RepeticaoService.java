package com.MensurA.web.features.repeticoes.service;

import com.MensurA.web.commom.exception.RepeticaoNaoEncontradaException;
import com.MensurA.web.features.mensuracoes.model.Mensuracao;
import com.MensurA.web.features.mensuracoes.repository.MensuracaoRepository;
import com.MensurA.web.features.repeticoes.dto.RepeticaoDTO;
import com.MensurA.web.features.repeticoes.model.Repeticao;
import com.MensurA.web.features.repeticoes.repository.RepeticaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepeticaoService {

    private final RepeticaoRepository repeticaoRepository;
    private final MensuracaoRepository mensuracaoRepository;

    public Page<RepeticaoDTO> listarTodasRepeticoes(Pageable pageable) {
        return repeticaoRepository.findAll(pageable)
                .map(RepeticaoDTO::from);
    }

    public Page<RepeticaoDTO> listarRepeticoesByMensuracao(Pageable pageable, Long mensuracaoId) {
        return repeticaoRepository.findAllByMensuracao_Id(pageable, mensuracaoId)
                .map(RepeticaoDTO::from);
    }

    public RepeticaoDTO getRepeticao(Long id) {
        return repeticaoRepository.findById(id)
                .map(RepeticaoDTO::from)
                .orElseThrow(() -> new RepeticaoNaoEncontradaException(id));
    }

    public void delete(Long id) {
        repeticaoRepository.findById(id).map(repeticao -> {
            repeticaoRepository.delete(repeticao);
            return true;
        }).orElseThrow(() -> new RepeticaoNaoEncontradaException(id));
    }

    public RepeticaoDTO criarRepeticao(RepeticaoDTO repeticaoDTO) {
        Mensuracao mensuracao = mensuracaoRepository.findById(repeticaoDTO.mensuracaoId())
                .orElseThrow(() -> new RepeticaoNaoEncontradaException(repeticaoDTO.mensuracaoId()));
        Repeticao repeticao = new Repeticao();
        repeticao.setMensuracao(mensuracao);
        repeticao.setDor(repeticaoDTO.dor());
        repeticao.setExcursao(repeticaoDTO.excursao());
        repeticao.setAnguloFinal(repeticaoDTO.anguloFinal());
        repeticao.setAnguloInicial(repeticaoDTO.anguloInicial());
        repeticao.setObservacoes(repeticaoDTO.observacoes());
        repeticao.setSerie(repeticaoDTO.serie());
        return RepeticaoDTO.from(repeticaoRepository.save(repeticao));
    }
}
