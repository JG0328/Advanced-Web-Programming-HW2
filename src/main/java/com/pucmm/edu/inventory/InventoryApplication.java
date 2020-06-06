package com.pucmm.edu.inventory;

import com.pucmm.edu.inventory.Services.MyUserDetailsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(InventoryApplication.class, args);
        MyUserDetailsService myUserDetailsService;

        try {
            myUserDetailsService = (MyUserDetailsService) applicationContext.getBean("myUserDetailsService");
            myUserDetailsService.createAdmin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
