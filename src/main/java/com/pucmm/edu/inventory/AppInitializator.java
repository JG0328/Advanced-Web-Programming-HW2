package com.pucmm.edu.inventory;

import com.pucmm.edu.inventory.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AppInitializator {
    @Autowired
    UsersService usersService;

    @PostConstruct
    private void initConfig() {
        usersService.createAdmin();
    }
}
