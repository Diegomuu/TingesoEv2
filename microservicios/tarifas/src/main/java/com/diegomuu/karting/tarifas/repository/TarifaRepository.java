package com.diegomuu.karting.tarifas.repository;

import com.diegomuu.karting.tarifas.entity.TarifaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<TarifaEntity, Long> {

}
