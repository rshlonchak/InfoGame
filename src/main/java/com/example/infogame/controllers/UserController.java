package com.example.infogame.controllers;

import com.example.infogame.dto.user.UserCreateDto;
import com.example.infogame.dto.user.UserResponseDto;
import com.example.infogame.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDto> listUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.createUser(userCreateDto);
    }
}
