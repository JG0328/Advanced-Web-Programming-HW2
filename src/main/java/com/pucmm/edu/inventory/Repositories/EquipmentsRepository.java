package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Category;
import com.pucmm.edu.inventory.Entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentsRepository extends JpaRepository<Equipment, Integer> {
    List<Equipment> findAllByEnabled(Boolean enabled);
}
