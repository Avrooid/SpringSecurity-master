package ru.Burakov.SpringSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Burakov.SpringSecurity.models.MainModel;
import ru.Burakov.SpringSecurity.repositoty.MainModelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainModelService {
    private final MainModelRepository mainModelRepository;

    public List<MainModel> getMainModels() {
        return mainModelRepository.findAll();
    }
    public MainModel getMainModelById(Long id) {
        return mainModelRepository.getReferenceById(id);
    }
}
