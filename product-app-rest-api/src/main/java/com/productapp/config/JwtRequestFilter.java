package com.productapp.config;

import com.productapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//      get header with name authorization from request
        String  headerValue= request.getHeader("Authorization");
        String jwtToken =null;
        String username=null;

//        check if header is not null and starts with Bearer
        if(headerValue!=null && headerValue.startsWith("Bearer")){
//          Bearer ebhwdhwidj.69efef.ioffnqofo

            jwtToken= headerValue.substring(7);
            //get the username
            username=jwtTokenUtil.getUsernameFromToken(jwtToken);
        }else{
            logger.warn("Invalid Header");
        }

//        if the username is not null and the security context is not null
//        then specify the type of authentication

        if(username!=null && SecurityContextHolder.getContext()!=null){
            //check if the username is available in the databse
            UserDetails details = userDetailsService.loadUserByUsername(username);

            //configure the authentication type
            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER"));

            UsernamePasswordAuthenticationToken authenticationToken=
                    new UsernamePasswordAuthenticationToken(details.getUsername(),null, authorities);
//            set the authentication type
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            set the security context for the security context
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }



        // no header means move to the next filter and th eds
        filterChain.doFilter(request,response);
    }
}
