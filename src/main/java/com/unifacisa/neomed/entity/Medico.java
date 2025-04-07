package com.unifacisa.neomed.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Medico extends ProfissionalDeSaude {
	
	private Integer crm;
	
}
