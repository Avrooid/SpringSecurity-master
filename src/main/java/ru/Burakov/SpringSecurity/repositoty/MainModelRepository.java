package ru.Burakov.SpringSecurity.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.SpringSecurity.models.MainModel;

public interface MainModelRepository extends JpaRepository<MainModel, Long> {

}
