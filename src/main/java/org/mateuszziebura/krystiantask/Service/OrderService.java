package org.mateuszziebura.krystiantask.Service;

import org.mateuszziebura.krystiantask.domain.Task;

import java.util.List;

public interface OrderService {
    List<Task> findAll();
}