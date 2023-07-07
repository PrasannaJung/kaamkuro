package com.kaamkuro.kaamkuro.service.impl;

import com.kaamkuro.kaamkuro.config.PasswordEncoderUtil;
import com.kaamkuro.kaamkuro.dto.NewUser;
import com.kaamkuro.kaamkuro.entity.AuthUser;
import com.kaamkuro.kaamkuro.entity.Role;
import com.kaamkuro.kaamkuro.repo.AuthUserRepo;
import com.kaamkuro.kaamkuro.repo.RoleRepo;
import com.kaamkuro.kaamkuro.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserRepo authUserRepo;
    private final RoleRepo roleRepo;
    @Override
    public void saveUser(NewUser newUser) {
        AuthUser user = new AuthUser();
        user.setEmail(newUser.getEmail());
        Role role=roleRepo.findById(newUser.getRole()).get();
        user.setRole(role);
        user.setPassword(PasswordEncoderUtil.getInstance().encode(newUser
                .getPassword()));
        authUserRepo.save(user);
    }
}
