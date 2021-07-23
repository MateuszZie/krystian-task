package org.mateuszziebura.krystiantask.Service;

import org.mateuszziebura.krystiantask.domain.History;
import org.mateuszziebura.krystiantask.domain.Task;

import java.util.List;

public interface OrderService {
    List<Task> findAll();
    Task save(Task task);
    List<History> history(Integer id);
}
