package com.unifacisa.neomed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
