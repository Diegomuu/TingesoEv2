package com.diegomuu.karting.tarifas.services;

import com.diegomuu.karting.tarifas.entity.TarifaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diegomuu.karting.tarifas.repository.TarifaRepository;

import java.util.List;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    // Read del crud
    public List<TarifaEntity> getAllTarifas() {
        return tarifaRepository.findAll();
    }

    // Create del crud
    public TarifaEntity createTarifa(TarifaEntity tarifa) {
        return tarifaRepository.save(tarifa);
    }
}
