package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {
    Category findById(int id);
    List<Category> findAllByEnabled(Boolean enabled);
    List<Category> findAllByParentCategoryNullAndEnabled(Boolean enabled);
    List<Category> findByParentCategoryNotNullAndEnabled(Boolean enabled);
}
