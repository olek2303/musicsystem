package dev.musicsystem.musicsystem.services;

import dev.musicsystem.musicsystem.entity.User;
import dev.musicsystem.musicsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User UserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> allUsers() { return userRepository.findAll(); }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public boolean userExists(User user) {
        return userRepository.existsById(user.getUserId());
    }
}
