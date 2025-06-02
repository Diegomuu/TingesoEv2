package com.diegomuu.clientes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private boolean cumpleanos;
    private int visitasMensuales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(boolean cumpleanos) {
        this.cumpleanos = cumpleanos;
    }

    public int getVisitasMensuales() {
        return visitasMensuales;
    }

    public void setVisitasMensuales(int visitasMensuales) {
        this.visitasMensuales = visitasMensuales;
    }
}

