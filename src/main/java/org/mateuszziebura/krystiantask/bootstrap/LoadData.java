package org.mateuszziebura.krystiantask.bootstrap;

import lombok.RequiredArgsConstructor;
import org.mateuszziebura.krystiantask.domain.Task;
import org.mateuszziebura.krystiantask.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class LoadData implements CommandLineRunner {

    private final TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        if(taskRepository.findAll().size()==0){
            loadData();
        }
    }

    private void loadData() {
        Task task = Task.builder().orderDeadline("2018-09-01 09:01:15").quantityPlaned(100).quantityCheckedIn(80).build();
        Task task2 = Task.builder().orderDeadline("2019-09-01 09:01:15").quantityPlaned(200).quantityCheckedIn(120).build();
        Task task3 = Task.builder().orderDeadline("2018-10-01 09:01:15").quantityPlaned(321).quantityCheckedIn(43).build();
        Task task4 = Task.builder().orderDeadline("2018-09-01 22:05:15").quantityPlaned(200).quantityCheckedIn(25).build();

        taskRepository.save(task);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);
    }
}
