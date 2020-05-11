package com.example.wangs.common;

import com.example.wangs.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * @author wangsheng
 */
public class UserUtils {

    public static User getCurrentHr() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
