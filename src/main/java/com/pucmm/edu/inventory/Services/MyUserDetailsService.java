package com.pucmm.edu.inventory.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pucmm.edu.inventory.Entities.Role;
import com.pucmm.edu.inventory.Entities.User;
import com.pucmm.edu.inventory.Repositories.RolesRepository;
import com.pucmm.edu.inventory.Repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);

        if (user == null) {
            System.out.println("User not found: " + username);
            throw new UsernameNotFoundException("User " + username + " is not in the DB");
        }

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : user.getRolSet()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(),
                user.isActive(), true, true, true, grantedAuthorities);
    }

    @Transactional
    public void createAdmin() {
        if (!findAdmin()) {
            Role role = new Role("ROLE_ADMIN");
            rolesRepository.save(role);

            User admin = new User("admin", "admin", new HashSet<>(Arrays.asList(role)), true);

            usersRepository.save(admin);
        }
    }

    private boolean findAdmin() {
        Role role = rolesRepository.findByRole("ROLE_ADMIN");
        if (role == null)
            return false;
        return true;
    }
}