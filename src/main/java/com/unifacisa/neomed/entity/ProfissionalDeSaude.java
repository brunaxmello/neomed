package com.unifacisa.neomed.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unifacisa.neomed.Avaliacao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class ProfissionalDeSaude extends Usuario {
	
	private double valorConsulta;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao", referencedColumnName = "id") // localização é referenciado
    @JsonManagedReference // Lado gerenciador
    private Localizacao localizacao;
	
    @OneToMany(mappedBy = "ProfissionalDeSaude", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Lado gerenciador
    private List<Avaliacao> avaliacoes = new ArrayList<>();
	
    @ManyToMany
    @JoinTable(
        name = "ProfissionalDeSaude_especializacao", // Nome da tabela intermediária
        joinColumns = @JoinColumn(name = "ProfissionalDeSaude_id"), // FK para Profissional De Saude
        inverseJoinColumns = @JoinColumn(name = "especializacao_id") // FK para Especializacao
    )
    @JsonManagedReference // Lado gerenciador
    private List<Especializacao> especializacoes = new ArrayList<>();

}
