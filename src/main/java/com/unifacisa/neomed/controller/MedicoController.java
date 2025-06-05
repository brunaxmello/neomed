package com.unifacisa.neomed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.neomed.entity.Medico;
import com.unifacisa.neomed.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@GetMapping
	public List<Medico> lisarTodos() {
		return medicoService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
		Medico medico = medicoService.buscarPorId(id);
		return ResponseEntity.ok(medico);
	}
	
	@PostMapping(consumes = "application/json")
    public ResponseEntity<Medico> criar(@RequestBody Medico medico) {
        Medico novoMedico = medicoService.salvar(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

	@PatchMapping("/{id}")
	public ResponseEntity<Medico> atualizarParcialmente(@PathVariable Long id, @RequestBody Medico dadosAtualizacao) {
		Medico medicoAtualizado = medicoService.atualizarParcialmenteMedico(id, dadosAtualizacao);
		return ResponseEntity.ok(medicoAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		medicoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
}