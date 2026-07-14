package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.service.PublicService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    private final PublicService publicService;

    public PublicController(PublicService publicService) {
        this.publicService = publicService;
    }

    @PostMapping("/login")
    public String Login(@RequestBody LoginDto loginDto) {
        return publicService.login(loginDto);
    }
}
