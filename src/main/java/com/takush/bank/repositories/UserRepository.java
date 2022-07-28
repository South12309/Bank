package com.takush.bank.repositories;

import com.takush.bank.entities.UserAbs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAbs, Long> {

    Optional<UserAbs> findByName(String username);
    Optional<UserAbs> findByLogin(String login);

    UserAbs save(UserAbs user);
}
