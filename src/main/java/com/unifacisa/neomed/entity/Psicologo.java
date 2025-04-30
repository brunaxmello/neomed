package com.unifacisa.neomed.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Psicologo  extends ProfissionalDeSaude{
	
	private Integer crp;

}
