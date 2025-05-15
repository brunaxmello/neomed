package com.unifacisa.neomed.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String nome;
	
	@Column(length = 50, unique = true)
	private String email;

	@Column(length = 50)
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "localizacao", referencedColumnName = "id") // localização é referenciado
	@JsonManagedReference // Lado gerenciador
	private Localizacao localizacao;
}