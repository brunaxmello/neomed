package com.unifacisa.neomed.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Especializacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(length = 50, unique = true)
	private String nome;

	@ManyToMany(mappedBy = "especializacoes")
	@JsonBackReference("profissional-especializacoes") // mesmo nome usado em ProfissionalDeSaude
	private List<ProfissionalDeSaude> profissionalDeSaude;

}
