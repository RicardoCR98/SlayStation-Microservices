package com.microservice_user.controller;

import com.microservice_user.entity.SecurityQuestion;
import com.microservice_user.entity.User;
import com.microservice_user.service.ISecurityQuestionService;
import com.microservice_user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> findById(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<User> getUserByEmail(@RequestBody User user) {
        return ResponseEntity.ok(userService.getUserByEmail(user.getUserEmail()));
    }


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setUserId(id);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @Autowired
    private ISecurityQuestionService securityQuestionService;

    @PostMapping("/create/security-questions/{userId}")
    public ResponseEntity<SecurityQuestion> addSecurityQuestion(
            @PathVariable Integer userId,
            @RequestBody SecurityQuestion securityQuestion) {
        User user = userService.getUserById(userId);
        securityQuestion.setUser(user);
        SecurityQuestion createdQuestion = securityQuestionService.createSecurityQuestion(securityQuestion);
        return ResponseEntity.ok(createdQuestion);
    }

    @GetMapping("/security-questions/{userId}")
    public ResponseEntity<List<SecurityQuestion>> getUserSecurityQuestions(@PathVariable Integer userId) {
        List<SecurityQuestion> questions = securityQuestionService.getSecurityQuestionsByUserId(userId);
        return ResponseEntity.ok(questions);
    }
}
