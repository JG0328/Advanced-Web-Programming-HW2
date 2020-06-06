package com.pucmm.edu.inventory.Repositories;

import java.util.List;
import java.util.Set;

import com.pucmm.edu.inventory.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUser(String user);

    User findById(int id);

    List<User> findAllByIsActive(Boolean isActive);
}