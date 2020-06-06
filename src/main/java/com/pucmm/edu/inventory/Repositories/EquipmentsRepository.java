package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentsRepository extends JpaRepository<Equipment, Integer> {
}
