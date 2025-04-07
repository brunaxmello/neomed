package com.unifacisa.neomed.entity;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

    private String cargo;

    // Getter for cargo
    public String getCargo() {
        return cargo;
    }

    // Setter for cargo
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}