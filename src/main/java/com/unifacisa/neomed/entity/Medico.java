package com.unifacisa.neomed.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unifacisa.neomed.Avaliacao;
import com.unifacisa.neomed.Localizacao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Medico extends Usuario {
	
	@Getter @Setter
	private Integer crm;
	
	@Getter @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao", referencedColumnName = "id") // localização é referenciado
    @JsonManagedReference // Lado gerenciador
    private Localizacao localizacao;
	
	@Getter @Setter
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Lado gerenciador
    private List<Avaliacao> avaliacoes = new ArrayList<>();
	
	
	@Getter @Setter
    @ManyToMany
    @JoinTable(
        name = "medico_especializacao", // Nome da tabela intermediária
        joinColumns = @JoinColumn(name = "medico_id"), // FK para Meidco
        inverseJoinColumns = @JoinColumn(name = "especializacao_id") // FK para Especializacao
    )
    @JsonManagedReference // Lado gerenciador
    private List<Especializacao> especializacoes = new ArrayList<>();
	
}
