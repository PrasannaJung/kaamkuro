package com.kaamkuro.kaamkuro.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{

        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home","/lalit_css/*","/login","/signup/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
        ;

        return httpSecurity.build();
    }
}
