package com.microservice_user.service;

import com.microservice_user.entity.SecurityQuestion;
import com.microservice_user.persistence.SecurityQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityQuestionServiceImpl implements ISecurityQuestionService{

    @Autowired
    private SecurityQuestionRepository securityQuestionRepository;

    @Override
    public SecurityQuestion createSecurityQuestion(SecurityQuestion securityQuestion) {
        return securityQuestionRepository.save(securityQuestion);
    }

    @Override
    public SecurityQuestion getSecurityQuestionById(Integer id) {
        return securityQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Security Question not found"));
    }

    @Override
    public List<SecurityQuestion> getSecurityQuestionsByUserId(Integer userId) {
        return securityQuestionRepository.findByUserId(userId);
    }

    @Override
    public SecurityQuestion updateSecurityQuestion(SecurityQuestion securityQuestion) {
        if (!securityQuestionRepository.existsById(securityQuestion.getSecurityQuestionId())) {
            throw new RuntimeException("Security Question not found");
        }
        return securityQuestionRepository.save(securityQuestion);
    }

    @Override
    public void deleteSecurityQuestion(Integer id) {
        securityQuestionRepository.deleteById(id);
    }
}

