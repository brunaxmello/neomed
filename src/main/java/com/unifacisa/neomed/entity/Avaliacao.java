package com.unifacisa.neomed;

import org.hibernate.annotations.DialectOverride.GeneratedColumns;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.unifacisa.neomed.entity.Medico;
import com.unifacisa.neomed.entity.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer nota;
	private String comentario;
	
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Medico medico;

	public Avaliacao(Long id, Integer nota, String comentario, Usuario usuario, Medico medico) {
		super();
		this.id = id;
		this.nota = nota;
		this.comentario = comentario;
		this.usuario = usuario;
		this.medico = medico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
	
}
