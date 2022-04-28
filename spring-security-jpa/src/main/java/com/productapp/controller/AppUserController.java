package com.productapp.controller;

import com.productapp.model.AppUser;
import com.productapp.service.IAppUSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    private IAppUSerService appUSerService;

    @Autowired
    public void setAppUSerService(IAppUSerService appUSerService) {
        this.appUSerService = appUSerService;
    }

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/")
    public  void addUser(@RequestBody AppUser appUser){
        String username= appUser.getUsername();
        String password= appUser.getPassword();
        String encodedPassword= passwordEncoder.encode(password);
        AppUser user = new AppUser(username,encodedPassword);
        appUSerService.addUSer(user);
    }


}
