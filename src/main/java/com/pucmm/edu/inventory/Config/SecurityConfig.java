package com.pucmm.edu.inventory.Config;

import com.pucmm.edu.inventory.Services.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Required for H2
        http.csrf().disable();
        http.headers().frameOptions().disable();

        // The pages does not require login
        http.authorizeRequests().antMatchers("/dbconsole/**").permitAll().antMatchers("/", "/login", "/logout")
                .permitAll();

        // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/user").access("hasRole('ROLE_USER')");

        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin", "/index**", "/crear**", "/historial")
                .access("hasRole('ROLE_ADMIN')");

        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginPage("/login")//
                .usernameParameter("username").passwordParameter("password").and().formLogin()
                .successHandler(authSuccessHandler)
                // Config for Logout Page
                .and().logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.css");
        web.ignoring().antMatchers("/*.js");
    }
}