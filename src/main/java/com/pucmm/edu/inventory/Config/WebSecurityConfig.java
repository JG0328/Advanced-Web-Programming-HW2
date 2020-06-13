package com.pucmm.edu.inventory.Config;

import com.pucmm.edu.inventory.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthSuccessHandler successHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests().antMatchers("/dbconsole/**").permitAll().antMatchers("/", "/login", "/logout").permitAll();

        http.authorizeRequests().antMatchers("**/create").access("hasRole('ROLE_ADMIN')");

//        http.authorizeRequests().antMatchers("/admin", "/index**", "/crear**", "/historial").access("hasRole('ROLE_ADMIN')");

//        http.authorizeRequests().and().formLogin()//
//                .loginPage("/login")//
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().formLogin().successHandler(successHandler)
//                .and().logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.css");
        web.ignoring().antMatchers("/*.js");
    }
}