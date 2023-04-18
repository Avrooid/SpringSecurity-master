package ru.Burakov.SpringSecurity.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.Burakov.SpringSecurity.models.MyUser;
import ru.Burakov.SpringSecurity.models.MyUserDetails;
import ru.Burakov.SpringSecurity.repositoty.MyUserRepository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Cant find user");
        return new MyUserDetails(user);
    }
}
