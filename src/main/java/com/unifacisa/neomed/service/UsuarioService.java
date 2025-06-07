package com.unifacisa.neomed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.unifacisa.neomed.entity.Usuario;
import com.unifacisa.neomed.repository.UsuarioRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizarParcialmente(Long id, Usuario dadosAtualizacao) {
		Usuario usuario = buscarPorId(id);
		
		if (dadosAtualizacao.getNome() != null) {
			usuario.setNome(dadosAtualizacao.getNome());
		}
		if (dadosAtualizacao.getEmail() != null) {
			usuario.setEmail(dadosAtualizacao.getEmail());
		}
		if (dadosAtualizacao.getSenha() != null) {
			usuario.setSenha(dadosAtualizacao.getSenha());
		}
		
		return usuarioRepository.save(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
	}

	public void deletar(Long id) {
		Usuario usuario = buscarPorId(id);
		usuarioRepository.delete(usuario);
	}

}
