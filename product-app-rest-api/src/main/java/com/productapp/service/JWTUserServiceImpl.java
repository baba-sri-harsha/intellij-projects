package com.productapp.service;


import com.productapp.model.JWTUser;
import com.productapp.repository.JWTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JWTUserServiceImpl implements UserDetailsService {

    @Autowired
    private JWTUserRepository jwtRepository;

    public void addUSer(JWTUser user){
        jwtRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JWTUser user = jwtRepository.findByUsername(username);
        if (user==null)
            throw new UsernameNotFoundException("Invalid Username");

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER"));

        UserDetails userDetails = new User(user.getUsername(),user.getPassword(),authorities);
        return userDetails;
    }
}
