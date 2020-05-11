package com.example.wangs.config;

import com.example.wangs.util.md5Util;
/**
 * @author wangsheng
 */
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {

        return md5Util.encode((String) rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return encodedPassword.equals(md5Util.encode((String) rawPassword));
    }
}
