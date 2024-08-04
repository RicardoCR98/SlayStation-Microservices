package com.microservice_user.service;

import com.microservice_user.entity.SecurityQuestion;

import java.util.List;

public interface ISecurityQuestionService {
    SecurityQuestion createSecurityQuestion(SecurityQuestion securityQuestion);
    SecurityQuestion getSecurityQuestionById(Integer id);
    List<SecurityQuestion> getSecurityQuestionsByUserId(Integer userId);
    SecurityQuestion updateSecurityQuestion(SecurityQuestion securityQuestion);
    void deleteSecurityQuestion(Integer id);
}
