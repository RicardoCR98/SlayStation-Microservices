package com.microservice_user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer userId;
    private String userName;
    private String userLastName;
    private String userEmail;
    private String userNickname;
    private String userPhone;
    private String userImage;
    private Integer userType;
}