package com.krishan.SecurityPO0.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailsService implements UserDetailsService {
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     /*  if(!username.equals("krishan")) {
           throw new UsernameNotFoundException("User not found");
       }
           String encodePass = new BCryptPasswordEncoder().encode("root");

          return User
                  .withUsername("krishan")
                  .password(encodePass)
                  .roles("USER")
                  .build();*/

        String encodePass = new BCryptPasswordEncoder().encode("root");
        if (username.equals("krishan")) {


          return User
                .withUsername("krishan")
                .password(encodePass)
                .roles("ADMIN")
                .build();
        }
        String encodePassRaj = new BCryptPasswordEncoder().encode("root");
        if(username.equals("raj")) {


            return User
                    .withUsername("raj")
                    .password(encodePassRaj)
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException("User not found ");
    }

}
