package org.mateuszziebura.krystiantask.repository;

import org.mateuszziebura.krystiantask.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer> {
}
