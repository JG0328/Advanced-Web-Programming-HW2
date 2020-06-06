package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Equipment;
import com.pucmm.edu.inventory.Entities.EquipmentRental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRentalsRepository extends JpaRepository<EquipmentRental, Integer> {
    EquipmentRental findByEquipment(Equipment equipment);
}