package com.unifacisa.neomed.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unifacisa.neomed.Avaliacao;
import com.unifacisa.neomed.Localizacao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Medico {
	
	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String email;
	@Getter
	private String senha;
	
	@Getter @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao", referencedColumnName = "id") // localização é referenciado
    @JsonManagedReference // Lado gerenciador
    private Localizacao localizacao;
	
	@Getter @Setter
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Lado gerenciador
    private List<Avaliacao> avaliacoes = new ArrayList<>();
	
//	  @Getter @Setter
//    @ManyToMany
//    @JoinTable(
//        name = "medico_especializacao", // Nome da tabela intermediária
//        joinColumns = @JoinColumn(name = "medico_id"), // FK para Meidco
//        inverseJoinColumns = @JoinColumn(name = "especializacao_id") // FK para Especializacao
//    )
//    @JsonManagedReference // Lado gerenciador
//    private List<Especializacao> especializacoes = new ArrayList<>();
	
}
