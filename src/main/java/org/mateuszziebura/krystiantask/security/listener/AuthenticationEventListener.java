package org.mateuszziebura.krystiantask.security.listener;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mateuszziebura.krystiantask.contoller.HomeController;
import org.mateuszziebura.krystiantask.domain.security.User;
import org.mateuszziebura.krystiantask.repository.security.UserRepository;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationEventListener {

    private final UserRepository userRepository;

    @EventListener
    public void listen(AuthenticationSuccessEvent event){

        log.debug("User Logg in OK");
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) event.getSource();
            org.springframework.security.core.userdetails.User secUser =  ( org.springframework.security.core.userdetails.User)token.getPrincipal();

        User user = userRepository.findByUsername(secUser.getUsername()).orElseThrow();
        user.setLogged(true);
        user.setLoginIn(Timestamp.valueOf(LocalDateTime.now()));

        userRepository.save(user);

    }
    @EventListener
    public void logout(LogoutSuccessEvent event){

        log.debug("User Logout OK");
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) event.getSource();
        org.springframework.security.core.userdetails.User secUser =  ( org.springframework.security.core.userdetails.User)token.getPrincipal();

        User user = userRepository.findByUsername(secUser.getUsername()).orElseThrow();
        user.setLogged(false);
        user.setLoginOut(Timestamp.valueOf(LocalDateTime.now()));

        userRepository.save(user);

    }
}
