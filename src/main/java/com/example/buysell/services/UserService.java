package com.example.buysell.services;

import com.example.buysell.enums.Role;
import com.example.buysell.models.User;
import com.example.buysell.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (repository.findByEmail(email) != null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_ADMIN);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        log.info("Savin new User {}", email);
        return true;
    }

    public List<User> list() {
        return repository.findAll();
    }

    public void banUser(Long id) {
        User user = repository.findById(id).orElse(null);
        if (user != null) {
            user.setActive(false);
            repository.save(user);
            log.info("User with id = {} ; email: {} has been BANED", user.getId(), user.getEmail());
        }
    }
}
