package com.productapp.controller;

import com.productapp.model.JWTUser;
import com.productapp.service.JWTUserServiceImpl;
import com.productapp.util.JwtTokenUtil;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUserServiceImpl jwtUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody JWTUser user) {
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        JWTUser jwtUser = new JWTUser(username, password);
        // save in db
        jwtUserService.addUSer(jwtUser);
        return ResponseEntity.ok("added");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody JWTUser jwtUser) {

        authenticate(jwtUser.getUsername(), jwtUser.getPassword());
//      check if username is in db
        UserDetails details = jwtUserService.loadUserByUsername(jwtUser.getUsername());
//        generate the IToken
        String jwtToken = jwtTokenUtil.generateToken(details);
        return ResponseEntity.ok(jwtToken);
    }


    @GetMapping("/greet")
    public String greet() {
        return "Jwt is too lengthy";

    }
//    to specify the type of authentication

    private void authenticate(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            System.out.println("invalid credentials");
        } catch (DisabledException e) {
            System.out.println("disabled");
        }
    }
}
