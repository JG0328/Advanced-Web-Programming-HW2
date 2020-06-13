package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.Category;
import com.pucmm.edu.inventory.Services.CategoriesServices;
import com.pucmm.edu.inventory.Services.EquipmentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class CategoryController {
    @Autowired
    private CategoriesServices categoriesServices;


    @RequestMapping(value = "/family", method = RequestMethod.GET)
    public ModelAndView main() {
        var params = new HashMap<String, Object>();
        params.put("categories", categoriesServices.findAll(true));
        return new ModelAndView("category", params);
    }

    @RequestMapping(value = "/family/create", method = RequestMethod.GET)
    public ModelAndView create_view() {
        var params = new HashMap<String, Object>();
        params.put("parent_categories", categoriesServices.getParentCategories(true));
        return new ModelAndView("add_category", params);
    }

    @RequestMapping(value = "/family/create", consumes = "application/x-www-form-urlencoded", method = RequestMethod.POST)
    public String create(Category category) {
        System.out.println(category);
        return "redirect:/";
    }

}

