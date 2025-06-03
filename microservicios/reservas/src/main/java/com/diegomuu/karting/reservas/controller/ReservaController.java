package com.diegomuu.karting.reservas.controller;

import com.diegomuu.karting.reservas.entity.ReservaEntity;
import com.diegomuu.karting.reservas.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/crear")
    public ResponseEntity<ReservaEntity> crearReserva(@RequestBody ReservaEntity reserva) {
        ReservaEntity nuevaReserva = reservaService.crearReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    @PutMapping("/confirmar/{id}")
    public ResponseEntity<ReservaEntity> confirmarReserva(@PathVariable Long id) {
        ReservaEntity reservaConfirmada = reservaService.confirmarReserva(id);
        return ResponseEntity.ok(reservaConfirmada);
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ReservaEntity> obtenerReservaPorCodigo(@PathVariable String codigo) {
        return reservaService.obtenerReservaPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}