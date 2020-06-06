package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {
    List<Category> findByParentCategoryNotNullAndIsActive(Boolean x);

    List<Category> findAllByIsActive(Boolean x);

    List<Category> findAllByIsActiveAndParentCategoryNull(Boolean x);
}
