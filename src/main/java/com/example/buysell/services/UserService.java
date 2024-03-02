package com.example.buysell.services;

import com.example.buysell.enums.Role;
import com.example.buysell.models.User;
import com.example.buysell.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private UserRepository repository;
    public boolean createUser(User user) {
        String email = user.getEmail();
        if (email == null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        log.info("Savin new User {}", email);
        return true;
    }
}
