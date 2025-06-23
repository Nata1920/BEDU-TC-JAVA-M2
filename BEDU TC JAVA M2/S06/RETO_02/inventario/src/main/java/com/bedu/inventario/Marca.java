package com.bedu.inventario;

import jakarta.persistence.*;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    protected Marca() {} // Constructor requerido por JPA

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return String.format("Marca[id=%d, nombre='%s']", id, nombre);
    }
}