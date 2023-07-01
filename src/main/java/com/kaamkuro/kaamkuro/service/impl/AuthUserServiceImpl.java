package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.dto.NewUser;
import com.kaamkuro.kaamkuro.entity.AuthUser;
import com.kaamkuro.kaamkuro.service.AuthUserService;

public class AuthUserServiceImpl implements AuthUserService {
    @Override
    public void saveUser(NewUser newUser) {
        AuthUser user = new AuthUser();
        user.setEmail(newUser.getEmail());
        user.setRole(newUser.getRole());
        user.setPassword(user.getPassword());
    }
}
