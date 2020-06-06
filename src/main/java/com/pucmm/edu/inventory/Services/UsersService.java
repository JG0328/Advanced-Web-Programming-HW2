package com.pucmm.edu.inventory.Services;

import com.pucmm.edu.inventory.Entities.Role;
import com.pucmm.edu.inventory.Entities.User;
import com.pucmm.edu.inventory.Repositories.RolesRepository;
import com.pucmm.edu.inventory.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RolesRepository rolesRepository;

    public void createAdmin() {
        if (usersRepository.findByUsername("admin") == null) {
            rolesRepository.save(new Role("ADMIN"));

            usersRepository.save(
                    new User("admin",
                            new BCryptPasswordEncoder().encode("admin"),
                            true,
                            rolesRepository.findByName("ADMIN")));
        }
    }
}
