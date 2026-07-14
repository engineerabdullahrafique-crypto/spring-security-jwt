package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.entity.User;

public interface PublicService {
    String login(LoginDto loginDto);
}
