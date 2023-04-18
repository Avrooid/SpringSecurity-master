package ru.Burakov.SpringSecurity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.Burakov.SpringSecurity.models.MainModel;
import ru.Burakov.SpringSecurity.models.MyUser;
import ru.Burakov.SpringSecurity.models.RegisterRequest;
import ru.Burakov.SpringSecurity.repositoty.MainModelRepository;
import ru.Burakov.SpringSecurity.repositoty.MyUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainModelService {
    private final MainModelRepository mainModelRepository;
    private final MyUserRepository myUserRepository;
    private final PasswordEncoder passwordEncoder;

    public List<MainModel> getMainModels() {
        return mainModelRepository.findAll();
    }
    public MainModel getMainModelById(Long id) {
        return mainModelRepository.getReferenceById(id);
    }

    public void register(RegisterRequest request) {
        var user = MyUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .role("ROLE_USER")
                .build();
        myUserRepository.save(user);
        log.info("Saving new User with username: {}", user.getUsername());
    }
}
