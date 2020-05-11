package com.example.wangs.controller;

import com.example.wangs.entity.Role;
import com.example.wangs.entity.User;
import com.example.wangs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangsheng
 */
@RestController
public class JoinController {
    @Autowired
    UserMapper usermapper;


    @RequestMapping("/test")
    public List<Role> test(@RequestParam String id){
        List<Role> rolesByHrId = usermapper.getRolesByUserId(id);
        return rolesByHrId;
    }

    @RequestMapping("/userList")
    public User userList(@RequestParam String username){
        User user = usermapper.loadUserByUsername(username);
        return user;
    }
}
