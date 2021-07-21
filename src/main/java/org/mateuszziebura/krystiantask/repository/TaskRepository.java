package org.mateuszziebura.krystiantask.repository;

import org.mateuszziebura.krystiantask.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
