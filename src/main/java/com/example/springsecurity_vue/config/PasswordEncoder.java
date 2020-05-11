package com.example.springsecurity_vue.config;

import com.example.springsecurity_vue.util.MD5Util;

public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {

        return MD5Util.encode((String) rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
    }
}
