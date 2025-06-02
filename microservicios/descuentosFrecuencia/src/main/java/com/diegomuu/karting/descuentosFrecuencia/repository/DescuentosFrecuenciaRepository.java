package com.diegomuu.karting.descuentosFrecuencia.repository;

import com.diegomuu.karting.descuentosFrecuencia.entity.DescuentosFrecuenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescuentosFrecuenciaRepository extends JpaRepository<DescuentosFrecuenciaEntity,Long> {
    Optional<DescuentosFrecuenciaEntity> findTopByMinVisitasLessThanEqualAndMaxVisitasGreaterThanEqual(int visitas);
}
