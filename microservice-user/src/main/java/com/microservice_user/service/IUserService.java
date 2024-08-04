package com.microservice_user.service;

import com.microservice_user.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User createUser(User user);
    User getUserById(Integer id);
    User updateUser(User user);
    void deleteUser(Integer id);
}
