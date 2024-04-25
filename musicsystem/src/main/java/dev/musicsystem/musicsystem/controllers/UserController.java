package dev.musicsystem.musicsystem.controllers;

import dev.musicsystem.musicsystem.entity.Comment;
import dev.musicsystem.musicsystem.entity.User;
import dev.musicsystem.musicsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.allUsers();
    }

    @PostMapping("")
    public ResponseEntity<User> addUser(User user) {
        if (userService.userExists(user)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        User savedUser = userService.addUser(user);

        if (savedUser == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User existingUser = userService.UserById(userId);

        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        updatedUser.setUserId(userId);

        User savedUser = userService.addUser(updatedUser);

        if (savedUser == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        User existingUser = userService.UserById(userId);

        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userService.deleteById(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
