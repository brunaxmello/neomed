package com.unifacisa.neomed.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.neomed.entity.Localizacao;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
    Optional<Localizacao> findByUsuarioId(Long usuarioId);
}
