package com.kaamkuro.kaamkuro.repo;

import com.kaamkuro.kaamkuro.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthUserRepo extends JpaRepository<AuthUser,Integer> {

    Optional<AuthUser> findByEmail(String email);

}
