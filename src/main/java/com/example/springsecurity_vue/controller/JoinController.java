package com.example.springsecurity_vue.controller;

import com.example.springsecurity_vue.entity.Role;
import com.example.springsecurity_vue.entity.User;
import com.example.springsecurity_vue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoinController {
    @Autowired
    UserMapper usermapper;


    @RequestMapping("/test")
    public List<Role> test(@RequestParam String id){
        List<Role> rolesByHrId = usermapper.getRolesByHrId(id);
        return rolesByHrId;
    }

    @RequestMapping("/userList")
    public User userList(@RequestParam String username){
        User user = usermapper.loadUserByUsername(username);
        return user;
    }
}
