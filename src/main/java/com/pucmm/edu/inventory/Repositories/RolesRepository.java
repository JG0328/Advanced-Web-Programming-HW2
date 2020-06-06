package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
