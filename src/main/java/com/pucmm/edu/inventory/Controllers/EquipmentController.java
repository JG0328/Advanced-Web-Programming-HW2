package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.Equipment;
import com.pucmm.edu.inventory.Services.EquipmentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentsServices equipmentsServices;

    @RequestMapping(value = "/equipment", method = RequestMethod.GET)
    public ModelAndView main() {
        var params = new HashMap<String, Object>();
        params.put("equipments", equipmentsServices.findAll());
        return new ModelAndView("equipment", params);
    }

    @RequestMapping(value = "/equipment/add", method = RequestMethod.GET)
    public ModelAndView add() {
        var params = new HashMap<String, Object>();
        return new ModelAndView("add_equipment", params);
    }
}
