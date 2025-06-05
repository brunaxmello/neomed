package com.unifacisa.neomed.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Medico.class, name = "medico")
})
public abstract class ProfissionalDeSaude extends Usuario {

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
