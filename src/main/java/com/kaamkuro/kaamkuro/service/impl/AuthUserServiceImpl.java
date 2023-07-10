package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.utils.PasswordEncoderUtil;
import com.kaamkuro.kaamkuro.dto.NewUser;
import com.kaamkuro.kaamkuro.entity.AuthUser;
import com.kaamkuro.kaamkuro.repo.AuthUserRepo;
import com.kaamkuro.kaamkuro.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserRepo authUserRepo;

    @Override
    public void saveUser(NewUser newUser) {
        AuthUser user = new AuthUser();
        user.setEmail(newUser.getEmail());
        user.setRole(newUser.getRole());
        String encryptedPassword = PasswordEncoderUtil.getInstance().encode(newUser.getPassword());
        user.setPassword(encryptedPassword);
        authUserRepo.save(user);
    }
}
