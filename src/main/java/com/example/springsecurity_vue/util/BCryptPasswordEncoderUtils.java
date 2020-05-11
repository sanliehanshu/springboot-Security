package com.example.springsecurity_vue.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
        //boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$sX9LXSJjeOlpPaFeOfOLKu0xMkN/w5XLxWGQbgFeQxsezuFTEtChC");
    }
//    $2a$10$sX9LXSJjeOlpPaFeOfOLKu0xMkN/w5XLxWGQbgFeQxsezuFTEtChC


    public static void main(String[] args) {
        String password = "123456";
        String pwd = encodePassword(password);
        System.out.println(pwd);
        boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$sX9LXSJjeOlpPaFeOfOLKu0xMkN/w5XLxWGQbgFeQxsezuFTEtChC");
        System.out.println(matches);
        System.out.println(bCryptPasswordEncoder.matches(password,encodePassword(password)));
    }
}
