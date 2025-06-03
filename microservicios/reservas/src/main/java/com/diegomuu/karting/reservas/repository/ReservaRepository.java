package com.diegomuu.karting.reservas.repository;

import com.diegomuu.karting.reservas.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity,Long> {
    Optional<ReservaEntity> findByCodigo(String codigo); // Buscar reserva por código único
    List<ReservaEntity> findByFechaReserva(LocalDate fecha);
}
