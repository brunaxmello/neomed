package com.unifacisa.neomed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.neomed.entity.Localizacao;
import com.unifacisa.neomed.repository.LocalizacaoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LocalizacaoService {

    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }

    public Localizacao editar(Long usuarioId, Localizacao novaLocalizacao) {
        Localizacao existente = localizacaoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Localização não encontrada para o usuário."));

        if (novaLocalizacao.getCidade() != null) {
            existente.setCidade(novaLocalizacao.getCidade());
        }

        if (novaLocalizacao.getEstado() != null) {
            existente.setEstado(novaLocalizacao.getEstado());
        }

        if (novaLocalizacao.getCep() != null) {
            existente.setCep(novaLocalizacao.getCep());
        }

        return localizacaoRepository.save(existente);
    }

    public Localizacao buscarPorId(Long id) {
        return localizacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Localização com ID " + id + " não encontrada."));
    }

    public Localizacao criar(Localizacao novaLocalizacao) {
        return localizacaoRepository.save(novaLocalizacao);
    }

    public void deletar(Long id) {
        if (!localizacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Localização com ID " + id + " não encontrada.");
        }
        localizacaoRepository.deleteById(id);
    }
}
