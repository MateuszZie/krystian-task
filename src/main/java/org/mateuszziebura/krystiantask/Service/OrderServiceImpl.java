package org.mateuszziebura.krystiantask.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mateuszziebura.krystiantask.domain.History;
import org.mateuszziebura.krystiantask.domain.Task;
import org.mateuszziebura.krystiantask.domain.security.User;
import org.mateuszziebura.krystiantask.repository.TaskRepository;
import org.mateuszziebura.krystiantask.repository.security.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

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

    @Override
    public void addQuantity(String id, Integer quantity,String username) {
        Task task = taskRepository.findById(Integer.valueOf(id)).orElseThrow();
        task.setQuantityCheckedIn(task.getQuantityCheckedIn() + quantity);
        User user = userRepository.findByUsername(username).orElseThrow();
        History history = History.builder().task(task).checkIn(Timestamp.valueOf(LocalDateTime.now())).quantity(quantity)
                .userName(user.getFirstName() + " " + user.getLastName()).build();
        task.getHistories().add(history);
        taskRepository.save(task);

    }
}
