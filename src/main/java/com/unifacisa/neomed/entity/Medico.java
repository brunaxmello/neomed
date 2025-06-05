package com.unifacisa.neomed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Medico extends Usuario {

	@Column(unique = true)
	private Integer crm;
	
	private Double valorConsulta;

}
