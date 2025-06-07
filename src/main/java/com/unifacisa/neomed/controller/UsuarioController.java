package com.unifacisa.neomed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unifacisa.neomed.entity.Usuario;
import com.unifacisa.neomed.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = usuarioService.salvar(usuario);//
		return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Usuario> atualizarParcialmente(@PathVariable Long id, @RequestBody Usuario dadosAtualizacao) {
		Usuario usuarioAtualizado = usuarioService.atualizarParcialmente(id, dadosAtualizacao);
		return ResponseEntity.ok(usuarioAtualizado);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
