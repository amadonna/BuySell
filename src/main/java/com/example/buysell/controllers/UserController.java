package com.example.buysell.controllers;

import com.example.buysell.models.User;
import com.example.buysell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!service.createUser(user)) {
            model.addAttribute("errorMessage",
                    "User with email: " +
                            user.getEmail() +
                            "  is not found");
            return "registration";
        }
        return "redirect:/login";
    }
}
