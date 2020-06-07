package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Role;
import com.pucmm.edu.inventory.Entities.User;
import com.pucmm.edu.inventory.Repositories.RolesRepository;
import com.pucmm.edu.inventory.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Transactional
    public void createAdmin() {
        if (usersRepository.findByUsername("admin") == null) {
            rolesRepository.save(new Role("ROLE_ADMIN"));

            usersRepository.save(
                    new User("admin",
                            "admin",
                            true,
                            new HashSet<>(Arrays.asList(rolesRepository.findByName("ROLE_ADMIN")))));
        }
    }
}
