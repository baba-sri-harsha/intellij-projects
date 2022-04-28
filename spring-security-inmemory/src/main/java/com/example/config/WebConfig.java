package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfig  extends WebSecurityConfigurerAdapter {
        // do authentication  insert override

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //to do inmemory authentication
        // hard code the user name and password
        auth.inMemoryAuthentication()
                .withUser("baba")
                .password(passwordEncoder().encode("baba123"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN","USER"); //and method name
    }
    //encode the password we need to use brcypt password encoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //do authorization


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/products/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin();

    }
}
