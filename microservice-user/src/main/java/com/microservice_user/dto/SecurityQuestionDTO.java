package com.microservice_user.dto;

import lombok.Data;

@Data
public class SecurityQuestionDTO {
    private Integer questionId;
    private Integer userId;
    private String question;
    private String answer;
}
