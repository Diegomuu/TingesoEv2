package com.diegomuu.karting.descuentosFrecuencia.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String nombre;
    private boolean cumpleanos;
    private int visitasMensuales;

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
