package com.pucmm.edu.inventory.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView main() {
        var params = new HashMap<String, Object>();
        return new ModelAndView("index", params);
    }
}
