package org.mateuszziebura.krystiantask.bootstrap;

import lombok.RequiredArgsConstructor;
import org.mateuszziebura.krystiantask.domain.security.Authority;
import org.mateuszziebura.krystiantask.domain.security.User;
import org.mateuszziebura.krystiantask.repository.security.AuthorityRepository;
import org.mateuszziebura.krystiantask.repository.security.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().size()==0){
            loadUsers();
        }
    }

    private void loadUsers() {
        Authority savedUser =authorityRepository.save(Authority.builder().role("ROLE_USER").build());
        User user1 = User.builder().username("krystian").firstName("Krystian").lastName("Lis").authority(savedUser).password(passwordEncoder.encode("lis")).build();
        User user2 = User.builder().username("mateusz").firstName("Mateusz").lastName("Ziebura").authority(savedUser).password(passwordEncoder.encode("ziebura")).build();
        userRepository.save(user1);
        userRepository.save(user2);
    }


}
