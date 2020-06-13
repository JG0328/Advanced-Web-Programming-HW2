package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Category;
import com.pucmm.edu.inventory.Repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriesServices {
    @Autowired
    CategoriesRepository categoriesRepository;

    @Transactional
    public void createCategory(Category categories) {
        categoriesRepository.save(categories);
    }

    @Transactional
    public void deleteCategory(Category categories) {
        categories.setEnabled(false);
        categoriesRepository.save(categories);
    }

    public Category findCategoryById(int id) {
        return categoriesRepository.findById(id);
    }


    @Transactional
    public void setParentCategory(Category parentCategory, Category childCategory){
        childCategory.setParentCategory(parentCategory);
        categoriesRepository.save(parentCategory);
    }

    public List<Category> findAll(Boolean enabled){
        return categoriesRepository.findAllByEnabled(enabled);
    }

    public Category findCategory(int id){
        return categoriesRepository.findById(id);
    }
    public List<Category> getParentCategories(Boolean enabled){
        return categoriesRepository.findAllByParentCategoryNullAndEnabled(enabled);
    }
    public List<Category> getSubCategories(Boolean enabled){
        return categoriesRepository.findByParentCategoryNotNullAndEnabled(enabled);
    }

}
