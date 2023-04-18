package ru.Burakov.SpringSecurity.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.Burakov.SpringSecurity.models.MainModel;
import ru.Burakov.SpringSecurity.service.MainModelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final MainModelService mainModelService;

    @GetMapping("/user")
    public List<MainModel> getAll() {
        return mainModelService.getMainModels();
    }
    @GetMapping("/user/{id}")
    public MainModel getMainModelById(@PathVariable Long id) {
        return mainModelService.getMainModelById(id);
    }
    @GetMapping("/all")
    public String get() {
        return "Hello, everybody!";
    }
}
