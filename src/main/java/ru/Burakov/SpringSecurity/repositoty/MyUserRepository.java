package ru.Burakov.SpringSecurity.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.SpringSecurity.models.MyUser;


import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
