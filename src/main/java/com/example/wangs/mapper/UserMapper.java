package com.example.wangs.mapper;

import com.example.wangs.entity.Role;
import com.example.wangs.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作 user表的相应的mapper
 *  @author wangsheng
 *
 */
@Service
public interface UserMapper {
    /*
        @Select("select * from user where username=#{username}")
    *   根据username 进行查找
    *
    * */

    User loadUserByUsername(String username);

    /**
     *
     * @param id
     * @return
     * 根据id查找、后边mapper.xml  进行级联查询<select></select>
     *
     */
    List<Role> getRolesByUserId(String id);


}
