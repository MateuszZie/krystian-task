package org.mateuszziebura.krystiantask.repository;

import org.mateuszziebura.krystiantask.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
