package org.mateuszziebura.krystiantask.repository.security;

import org.mateuszziebura.krystiantask.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
}
