package com.example.demo.service.impl;

import com.example.demo.dto.LoginDto;
import com.example.demo.service.PublicService;
import com.example.demo.utils.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PublicServiceImpl implements PublicService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public PublicServiceImpl(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public String login(LoginDto loginDto) {

        System.out.println("Login attempt for: " + loginDto.getEmail());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getEmail(),
                            loginDto.getPassword()
                    )
            );

            if (authentication.isAuthenticated()) {
                return jwtUtils.generateToken(authentication.getName());
            }

            System.out.println("Authentication successful");

            return "Login successful for user: " + authentication.getName();

        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());

            return "Invalid email or password.";
        }
    }
}
