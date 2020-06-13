package com.pucmm.edu.inventory.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class EquipmentController {
    @RequestMapping(value = "/equipment", method = RequestMethod.GET)
    public ModelAndView main() {
        var params = new HashMap<String, Object>();
        return new ModelAndView("equipment", params);
    }
}
