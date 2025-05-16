package com.diegomuu.karting.tarifas.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarifa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int vueltas;  // Ej: 10, 15, 20

    @Column(name = "tiempo_max_minutos", nullable = false)
    private int tiempoMaxMinutos;  // Ej: 10, 15, 20

    @Column(nullable = false)
    private double precio;  // Ej: 15000 (CLP)

}

