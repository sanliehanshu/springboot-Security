package com.example.wangs.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wangsheng
 * BCryptPasswordEncoder 由于使用随机盐 每次生成的密码都不同 但是可以 matches
 */
public class bcryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
        //boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$sX9LXSJjeOlpPaFeOfOLKu0xMkN/w5XLxWGQbgFeQxsezuFTEtChC");
    }
//    $2a$10$sX9LXSJjeOlpPaFeOfOLKu0xMkN/w5XLxWGQbgFeQxsezuFTEtChC


    public static void main(String[] args) {
        String password = "123456";
        //生成密码
        String pwd = encodePassword(password);
        System.out.println(pwd);
        //匹配
        boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$sX9LXSJjeOlpPaFeOfOLKu0xMkN/w5XLxWGQbgFeQxsezuFTEtChC");
        System.out.println(matches);
        System.out.println(bCryptPasswordEncoder.matches(password,encodePassword(password)));
    }
}
