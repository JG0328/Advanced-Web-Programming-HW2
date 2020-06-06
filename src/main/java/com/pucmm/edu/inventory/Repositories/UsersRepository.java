package com.pucmm.edu.inventory.Repositories;

import com.pucmm.edu.inventory.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
