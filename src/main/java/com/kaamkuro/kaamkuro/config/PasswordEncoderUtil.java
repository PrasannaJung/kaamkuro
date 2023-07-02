package com.kaamkuro.kaamkuro.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static BCryptPasswordEncoder getInstance(){
        return new BCryptPasswordEncoder();
    }
}
