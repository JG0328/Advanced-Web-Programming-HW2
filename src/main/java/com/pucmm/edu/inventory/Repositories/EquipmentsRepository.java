package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentsRepository extends JpaRepository<Equipment, String> {
    Equipment findByUuid(String uuid);
}