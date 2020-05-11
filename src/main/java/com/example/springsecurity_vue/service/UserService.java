package com.example.springsecurity_vue.service;

import com.example.springsecurity_vue.entity.User;
import com.example.springsecurity_vue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper usermapper;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User uer = usermapper.loadUserByUsername(s);
        if (uer == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return uer;
    }



}
