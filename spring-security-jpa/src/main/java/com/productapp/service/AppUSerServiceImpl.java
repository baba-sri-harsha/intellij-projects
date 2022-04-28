package com.productapp.service;

import com.productapp.model.AppUser;
import com.productapp.repository.IAppUserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AppUSerServiceImpl implements  IAppUSerService,UserDetailsService{

    private IAppUserRepository appUserRepository;
    @Autowired
    public void setAppUserRepository(IAppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       AppUser appUser = appUserRepository.findByUsername(username);
       String nusername= appUser.getUsername();
       String password =appUser.getPassword();

       //setRoles for the user
        GrantedAuthority authority= new SimpleGrantedAuthority("USer");
        GrantedAuthority authority1=new SimpleGrantedAuthority(("ADMIN"));
        //create a new user object user details interface
        UserDetails user= new User(nusername,password, Arrays.asList(authority,authority1));
        return user;
    }

    @Override
    public void addUSer(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void updateUser(AppUser appUser) {

    }

    @Override
    public void deleteUSer(int userId) {

    }
}
