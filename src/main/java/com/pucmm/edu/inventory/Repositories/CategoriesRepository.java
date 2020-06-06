package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {

}
