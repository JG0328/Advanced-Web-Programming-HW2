package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Equipment;
import com.pucmm.edu.inventory.Repositories.EquipmentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentsService {
    @Autowired
    EquipmentsRepository equipmentsRepository;

    public Equipment findEquipment(String uuid) {
        return equipmentsRepository.findByUuid(uuid);
    }
}