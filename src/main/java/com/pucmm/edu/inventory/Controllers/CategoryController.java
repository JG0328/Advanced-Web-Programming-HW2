package com.pucmm.edu.inventory.Controllers;

import com.pucmm.edu.inventory.Entities.Category;
import com.pucmm.edu.inventory.Services.CategoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        System.out.println(categoriesServices.findAll(true));
        return new ModelAndView("category/index", params);
    }

    @RequestMapping(value = "/family/create", method = RequestMethod.GET)
    public ModelAndView create_view() {
        var params = new HashMap<String, Object>();
        var category = new Category("", null, "", false);
        params.put("action", "/family/create");
        params.put("name", "Create");
        params.put("category", category);
        params.put("parent_categories", categoriesServices.getParentCategories(true));
        return new ModelAndView("category/data_form", params);
    }

    @RequestMapping(value = "/family/create", consumes = "application/x-www-form-urlencoded", method = RequestMethod.POST)
    public String create(Category category, @RequestParam("parent_category") String parentCategoryId) {
        Category parentCategory;
        try{
            int parentId = Integer.parseInt(parentCategoryId);
            parentCategory = categoriesServices.findCategoryById(parentId);
        }catch(Exception e){
            parentCategory = null;
        }
        category.setParentCategory(parentCategory);
        category.setEnabled(true);
        categoriesServices.save(category);
        return "redirect:/family";
    }

    @RequestMapping(value = "/family/update/{id}", method = RequestMethod.GET)
    public ModelAndView update_view(@PathVariable(value = "id") int id) {
        Category category = categoriesServices.findCategoryById(id);
        var params = new HashMap<String, Object>();
        params.put("action", "/family/update/" + category.getId());
        params.put("name", "Update");
        params.put("category", category);
        params.put("parent_categories", categoriesServices.getParentCategories(true));
        return new ModelAndView("category/data_form", params);
    }

    @RequestMapping(value = "/family/update/{id}",  consumes = "application/x-www-form-urlencoded", method = RequestMethod.POST)
    public String update(@PathVariable(value = "id") int id, @RequestParam("parent_category") int parentCategoryId, Category updatedValues) {
        Category category = categoriesServices.findCategoryById(id);
        Category parentCategory = categoriesServices.findCategoryById(parentCategoryId);
        category.setParentCategory(parentCategory);
        category.setName(updatedValues.getName());
        category.setDescription(updatedValues.getDescription());
        categoriesServices.save(category);
        return "redirect:/family";
    }

    @RequestMapping(value = "/family/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "id") int id) {
        categoriesServices.deleteCategory(categoriesServices.findCategoryById(id));
        return "redirect:/family";
    }

}

