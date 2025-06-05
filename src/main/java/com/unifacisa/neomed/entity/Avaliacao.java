package com.unifacisa.neomed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer nota;
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id") // Chave estrangeira no banco de dados
	@JsonBackReference("usuario-avaliacoes") // Lado inverso
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profissional_de_saude_id") // Chave estrangeira no banco de dados
	@JsonBackReference("profissional-avaliacoes") // Lado inverso
	private ProfissionalDeSaude profissionalDeSaude;

}