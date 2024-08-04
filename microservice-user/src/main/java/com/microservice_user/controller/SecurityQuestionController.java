package com.microservice_user.controller;

import com.microservice_user.entity.SecurityQuestion;
import com.microservice_user.service.ISecurityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security-questions")
public class SecurityQuestionController {
    @Autowired
    private ISecurityQuestionService securityQuestionService;

    @PostMapping
    public ResponseEntity<SecurityQuestion> createSecurityQuestion(@RequestBody SecurityQuestion securityQuestion) {
        SecurityQuestion createdQuestion = securityQuestionService.createSecurityQuestion(securityQuestion);
        return ResponseEntity.ok(createdQuestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecurityQuestion> getSecurityQuestion(@PathVariable Integer id) {
        SecurityQuestion question = securityQuestionService.getSecurityQuestionById(id);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SecurityQuestion>> getSecurityQuestionsByUserId(@PathVariable Integer userId) {
        List<SecurityQuestion> questions = securityQuestionService.getSecurityQuestionsByUserId(userId);
        return ResponseEntity.ok(questions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SecurityQuestion> updateSecurityQuestion(@PathVariable Integer id, @RequestBody SecurityQuestion securityQuestion) {
        securityQuestion.setSecurityQuestionId(id);
        SecurityQuestion updatedQuestion = securityQuestionService.updateSecurityQuestion(securityQuestion);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecurityQuestion(@PathVariable Integer id) {
        securityQuestionService.deleteSecurityQuestion(id);
        return ResponseEntity.ok().build();
    }
}
