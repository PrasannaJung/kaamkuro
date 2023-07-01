package com.kaamkuro.kaamkuro.repo;

import com.kaamkuro.kaamkuro.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepo extends JpaRepository<AuthUser,Integer> {
}
