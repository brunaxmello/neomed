package com.unifacisa.neomed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.unifacisa.neomed.entity.Medico;
import com.unifacisa.neomed.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	public List<Medico> listarTodos() {
		return medicoRepository.findAll();
	}

	public Medico atualizarParcialmenteMedico(Long id, Medico dadosAtualizacao) {
		Medico medico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));

		if (dadosAtualizacao.getCrm() != null) {
			medico.setCrm(dadosAtualizacao.getCrm());
		}

		return medicoRepository.save(medico);
	}

}
