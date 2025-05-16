package services;

import entity.TarifaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TarifaRepository;

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
