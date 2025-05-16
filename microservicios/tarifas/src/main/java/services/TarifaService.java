package services;

import entity.TatifaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TarifaRepository;

import java.util.List;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    // Read del crud
    public List<TatifaEntity> getAllTarifas() {
        return tarifaRepository.findAll();
    }

    // Create del crud
    public TatifaEntity createTarifa(TatifaEntity tarifa) {
        return tarifaRepository.save(tarifa);
    }
}
