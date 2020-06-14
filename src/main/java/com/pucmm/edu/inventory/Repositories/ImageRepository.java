package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
