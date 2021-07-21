package org.mateuszziebura.krystiantask.Service;

import lombok.RequiredArgsConstructor;
import org.mateuszziebura.krystiantask.domain.Task;
import org.mateuszziebura.krystiantask.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
