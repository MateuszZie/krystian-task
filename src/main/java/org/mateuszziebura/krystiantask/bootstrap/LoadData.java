package org.mateuszziebura.krystiantask.bootstrap;

import lombok.RequiredArgsConstructor;
import org.mateuszziebura.krystiantask.domain.History;
import org.mateuszziebura.krystiantask.domain.Task;
import org.mateuszziebura.krystiantask.domain.security.Authority;
import org.mateuszziebura.krystiantask.domain.security.User;
import org.mateuszziebura.krystiantask.repository.HistoryRepository;
import org.mateuszziebura.krystiantask.repository.security.AuthorityRepository;
import org.mateuszziebura.krystiantask.repository.TaskRepository;
import org.mateuszziebura.krystiantask.repository.security.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class LoadData implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final AuthorityRepository authorityRepository;
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(taskRepository.findAll().size()==0){
            loadUsers();
            loadData();
        }
    }

    private void loadUsers() {
        Authority savedUser =authorityRepository.save(Authority.builder().role("ROLE_USER").build());
        User user1 = User.builder().username("krystian").authority(savedUser).password(passwordEncoder.encode("lis")).build();

        userRepository.save(user1);
    }

    private void loadData() {

        Task task = Task.builder().orderDeadline("2018-09-01 09:01:15").quantityPlaned(100).quantityCheckedIn(80).build();
        Task task2 = Task.builder().orderDeadline("2019-09-01 09:01:15").quantityPlaned(200).quantityCheckedIn(120).build();
        Task task3 = Task.builder().orderDeadline("2018-10-01 09:01:15").quantityPlaned(321).quantityCheckedIn(43).build();
        Task task4 = Task.builder().orderDeadline("2018-09-01 22:05:15").quantityPlaned(200).quantityCheckedIn(25).build();

        History history = History.builder().quantity(50).task(task).userName("lol").checkIn(Timestamp.valueOf("2018-09-01 09:01:15")).build();
        History history2 = History.builder().quantity(100).task(task).userName("kol").checkIn(Timestamp.valueOf("2022-09-01 09:01:15")).build();

        task.setHistories(Set.of(history,history2));
        taskRepository.save(task);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);
    }
}
