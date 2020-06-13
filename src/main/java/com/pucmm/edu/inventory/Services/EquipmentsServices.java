package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Equipment;
import com.pucmm.edu.inventory.Repositories.EquipmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipmentsServices {
    @Autowired
    EquipmentsRepository equipmentsRepository;

    @Transactional
    public void createEquipment(Equipment equipment) {
        equipmentsRepository.save(equipment);
    }

    @Transactional
    public void deleteEquipment(Equipment equipment) {
        equipment.setEnabled(false);
        equipmentsRepository.save(equipment);
    }

    public Equipment findEquipmentById(int id) {
        return equipmentsRepository.findById(id).get();
    }

    @Transactional
    public void updateStock(Equipment equipment, int stock, int stockRent) {
        equipment.setStockRent(stockRent);
        equipment.setStock(stock);
        equipmentsRepository.save(equipment);
    }

//    public List<Equipment> listEquip(Boolean aBoolean, int stock) {
//
//        return equipmentsRepository.findAllByEnabledAndStockGreaterThan(aBoolean, stock);
//    }
}
