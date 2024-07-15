package com.wayback.loginsystem.repository;

import com.wayback.loginsystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserid(String userid);
    boolean existsByUserid(String userid);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
}
