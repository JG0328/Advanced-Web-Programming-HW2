package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.Category;
import com.pucmm.edu.inventory.Entities.Equipment;
import com.pucmm.edu.inventory.Services.CategoriesServices;
import com.pucmm.edu.inventory.Services.EquipmentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentsServices equipmentsServices;

    @Autowired
    private CategoriesServices categoriesServices;

    @RequestMapping(value = "/equipment", method = RequestMethod.GET)
    public ModelAndView main() {
        var params = new HashMap<String, Object>();
        params.put("equipments", equipmentsServices.findAllByEnabled(true));
        return new ModelAndView("equipment/index", params);
    }

    @RequestMapping(value = "/equipment/create", method = RequestMethod.GET)
    public ModelAndView create_view() {
        Equipment equipment = new Equipment("", 0, null, false, "", 0, 0);
        var params = new HashMap<String, Object>();
        params.put("action", "/equipment/create");
        params.put("name", "Create");
        params.put("equipment", equipment);
        params.put("categories", categoriesServices.getSubCategories(true));
        return new ModelAndView("equipment/data_form", params);
    }

    @RequestMapping(value = "/equipment/create", consumes = "application/x-www-form-urlencoded", method = RequestMethod.POST)
    public String create(Equipment equipment, @RequestParam("category") String categoryIdString) {
        Category category;
        try{
            int categoryId = Integer.parseInt(categoryIdString);
            category = categoriesServices.findCategoryById(categoryId);
        }catch(Exception e){
            category = null;
        }
        System.out.println(equipment.getRate());
        equipment.setCategory(category);
        equipment.setEnabled(true);
        equipmentsServices.save(equipment);
        return "redirect:/equipment";
    }

    @RequestMapping(value = "/equipment/update/{id}", method = RequestMethod.GET)
    public ModelAndView update_view(@PathVariable(value = "id") int id) {
        Equipment equipment = equipmentsServices.findEquipmentById(id);
        var params = new HashMap<String, Object>();
        params.put("action", "/equipment/update/" + equipment.getId());
        params.put("name", "Update");
        params.put("equipment", equipment);
        params.put("categories", categoriesServices.getSubCategories(true));
        return new ModelAndView("equipment/data_form", params);
    }

    @RequestMapping(value = "/equipment/update/{id}", consumes = "application/x-www-form-urlencoded", method = RequestMethod.POST)
    public String update(Equipment equipment, @RequestParam("category") String categoryIdString) {
        Category category;
        try{
            int categoryId = Integer.parseInt(categoryIdString);
            category = categoriesServices.findCategoryById(categoryId);
        }catch(Exception e){
            category = null;
        }
        System.out.println(equipment.getRate());
        equipment.setCategory(category);
        equipment.setEnabled(true);
        equipmentsServices.save(equipment);
        return "redirect:/equipment";
    }

    @RequestMapping(value = "/equipment/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "id") int id) {
        equipmentsServices.deleteEquipment(equipmentsServices.findEquipmentById(id));
        return "redirect:/equipment";
    }
}
