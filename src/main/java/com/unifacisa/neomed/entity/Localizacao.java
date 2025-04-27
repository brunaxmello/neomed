package com.unifacisa.neomed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter @Setter
    private String cidade;

    @Getter @Setter
    private String estado;

    @OneToOne(mappedBy = "localizacao")
    @JsonBackReference
    @Getter @Setter
    private ProfissionalDeSaude profissionalDeSaude; // <- Aqui mudou: antes era Medico, agora é ProfissionalDeSaude
}
