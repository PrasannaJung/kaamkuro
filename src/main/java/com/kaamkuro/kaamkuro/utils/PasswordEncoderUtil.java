package com.kaamkuro.kaamkuro.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static BCryptPasswordEncoder getInstance(){
        return new BCryptPasswordEncoder();
    }
}
