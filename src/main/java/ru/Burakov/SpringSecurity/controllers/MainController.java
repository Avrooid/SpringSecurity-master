package ru.Burakov.SpringSecurity.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.Burakov.SpringSecurity.service.MainModelService;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainModelService mainModelService;

    @GetMapping("/user")
    public String getAll(Model model) {
        model.addAttribute("users", mainModelService.getMainModels());
        return "users";
    }
    @GetMapping("/user/{id}")
    public String getMainModelById(Model model, @PathVariable Long id) {
        model.addAttribute("user", mainModelService.getMainModelById(id));
        return "user";
    }
    @GetMapping("/all")
    public String get() {
        return "success";
    }
}
