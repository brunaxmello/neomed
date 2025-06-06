package com.unifacisa.neomed.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class ProfissionalDeSaude extends Usuario {
	
	@Column(length = 50)
    private String tipo;

	private double valorConsulta;

	@OneToMany(mappedBy = "profissionalDeSaude", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("profissional-avaliacoes") // mesmo nome do backreference // Lado gerenciador
	private List<Avaliacao> avaliacoes = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "ProfissionalDeSaude_especializacao", // Nome da tabela intermediária
			joinColumns = @JoinColumn(name = "ProfissionalDeSaude_id"), // FK para Profissional De Saude
			inverseJoinColumns = @JoinColumn(name = "especializacao_id") // FK para Especializacao
	)
	@JsonManagedReference("profissional-especializacoes") // Lado gerenciador
	private List<Especializacao> especializacoes = new ArrayList<>();

}
