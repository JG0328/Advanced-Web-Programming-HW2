package com.pucmm.edu.inventory.Repositories;

import java.util.List;
import java.util.Set;

import com.pucmm.edu.inventory.Entities.Role;
import com.pucmm.edu.inventory.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, String> {
    User findByRolSet(Set<Role> roles);

    User findByUsername(String username);

    User findByUserUuid(String uuid);

    List<User> findAllByActive(Boolean enabled);
}