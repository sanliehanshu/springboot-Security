package com.example.springsecurity_vue.mapper;

import com.example.springsecurity_vue.entity.Role;
import com.example.springsecurity_vue.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMapper {
    /*@Select("select * from user where username=#{username}")*/
    User loadUserByUsername(String username);
    List<Role> getRolesByHrId(String id);


}
