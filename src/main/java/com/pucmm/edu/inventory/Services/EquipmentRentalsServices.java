package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.EquipmentRental;
import com.pucmm.edu.inventory.Repositories.EquipmentRentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipmentRentalsServices {
    @Autowired
    EquipmentRentalsRepository equipmentRentalsRepository;

    @Transactional
    public void createEquipmentRental(EquipmentRental equipmentRental) {
        equipmentRentalsRepository.save(equipmentRental);
    }

    @Transactional
    public void updateEquipmentRental(EquipmentRental equipmentRental, float cost, int days) {
        equipmentRental.setCost(cost);
        equipmentRental.setDays(days);

        equipmentRentalsRepository.save(equipmentRental);
    }

    @Transactional
    public void updateStatus(EquipmentRental equipmentRental, Boolean status) {
        equipmentRental.setReturned(status);
        equipmentRentalsRepository.save(equipmentRental);
    }
}
