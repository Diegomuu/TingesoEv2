package controller;

import entity.TatifaEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.TarifaService;

import java.util.List;

@RestController
@RequestMapping("tarifas")
public class TarifaController {

    public TarifaService tarifaService;

    @GetMapping("/read")
    public List<TatifaEntity> listarTatifas() {
        return tarifaService.getAllTarifas();
    }

    // Create (POST)
    @PostMapping("/create")
    public ResponseEntity<TatifaEntity> createTarifa(@RequestBody TatifaEntity tarifa) {
        TatifaEntity nuevaTarifa = tarifaService.createTarifa(tarifa);
        return new ResponseEntity<>(nuevaTarifa, HttpStatus.CREATED);
    }

}
