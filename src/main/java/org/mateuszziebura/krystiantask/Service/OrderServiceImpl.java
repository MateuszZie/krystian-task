package org.mateuszziebura.krystiantask.Service;

import lombok.RequiredArgsConstructor;
import org.mateuszziebura.krystiantask.domain.History;
import org.mateuszziebura.krystiantask.domain.Task;
import org.mateuszziebura.krystiantask.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<History> history(Integer id) {
        return new ArrayList<>(taskRepository.findById(id).orElseThrow().getHistories());
    }
}
