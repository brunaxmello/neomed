package com.unifacisa.neomed.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.neomed.entity.Localizacao;
import com.unifacisa.neomed.service.LocalizacaoService;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {
	
	@Autowired
	private LocalizacaoService localizacaoService;
	
	@PatchMapping("/{usuarioId}")
	public ResponseEntity<Localizacao> editar(@PathVariable Long usuarioId, @RequestBody Localizacao novaLocalizacao) {
		Localizacao atualizada = localizacaoService.editar(usuarioId, novaLocalizacao);
		return ResponseEntity.ok(atualizada);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Localizacao> buscarPorId(@PathVariable Long id) {
		Localizacao localizacao = localizacaoService.buscarPorId(id);
		return ResponseEntity.ok(localizacao);
	}

	@PostMapping
	public ResponseEntity<Localizacao> criar(@RequestBody Localizacao novaLocalizacao) {
		Localizacao criada = localizacaoService.criar(novaLocalizacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(criada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		localizacaoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
