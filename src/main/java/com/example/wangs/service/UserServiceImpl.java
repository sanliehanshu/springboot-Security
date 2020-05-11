package com.example.wangs.service;

import com.example.wangs.entity.User;
import com.example.wangs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author sanliehanshu
 */
@Service
public class UserServiceImpl implements UserDetailsService {
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
