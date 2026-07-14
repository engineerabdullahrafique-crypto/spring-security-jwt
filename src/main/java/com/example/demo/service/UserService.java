package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    UserDto getUserById(Long id);

    UserDto deleteUserById(Long id);

    UserDto updateUser(User user);

    List<UserDto> getAllUsers();
}