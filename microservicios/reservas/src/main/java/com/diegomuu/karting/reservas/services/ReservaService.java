package com.diegomuu.karting.reservas.services;

import com.diegomuu.karting.reservas.entity.ReservaEntity;
import com.diegomuu.karting.reservas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public ReservaEntity crearReserva(ReservaEntity reserva) {
        reserva.setCodigo(UUID.randomUUID().toString()); // Genera un código único
        reserva.setConfirmada(false); // Por defecto, la reserva está pendiente
        return reservaRepository.save(reserva);
    }

    public ReservaEntity confirmarReserva(Long reservaId) {
        ReservaEntity reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reserva.setConfirmada(true); // Cambia estado a confirmada
        return reservaRepository.save(reserva);
    }

    public Optional<ReservaEntity> obtenerReservaPorCodigo(String codigo) {
        return reservaRepository.findByCodigo(codigo);
    }
}
