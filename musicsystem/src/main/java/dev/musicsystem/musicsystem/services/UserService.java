package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.User;
import dev.musicsystem.musicsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User UserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
