package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Category;
import com.pucmm.edu.inventory.Repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    @Transactional
    public void saveCategory(Category category) {
        categoriesRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Category category) {
        category.setActive(false);
        categoriesRepository.save(category);
    }

    public List<Category> getCategories(Boolean x) {
        return categoriesRepository.findAllByIsActive(x);
    }

    public List<Category> getParentCategories(Boolean x) {
        return categoriesRepository.findAllByIsActiveAndParentCategoryNull(x);
    }

    public List<Category> getSubCategories(Boolean x) {
        return categoriesRepository.findByParentCategoryNotNullAndIsActive(x);
    }
}
