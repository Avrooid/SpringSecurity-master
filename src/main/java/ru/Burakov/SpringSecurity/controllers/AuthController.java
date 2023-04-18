package ru.Burakov.SpringSecurity.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.Burakov.SpringSecurity.models.RegisterRequest;
import ru.Burakov.SpringSecurity.service.MainModelService;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final MainModelService mainModelService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("request", new RegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("request") RegisterRequest request) {
        mainModelService.register(request);
        return "redirect:/login";
    }
}
