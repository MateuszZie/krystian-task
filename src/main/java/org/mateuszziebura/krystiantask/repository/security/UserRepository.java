package org.mateuszziebura.krystiantask.repository.security;

import org.mateuszziebura.krystiantask.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String s);
}
