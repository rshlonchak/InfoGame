package com.example.infogame.controllers;

import com.example.infogame.dto.user.UserCreateDto;
import com.example.infogame.dto.user.UserRenameDto;
import com.example.infogame.dto.user.UserResponseDto;
import com.example.infogame.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDto> listUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.createUser(userCreateDto);
    }

    @GetMapping("/user/{userId}")
    public UserResponseDto getUser(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/user/{userId}")
    public UserResponseDto renameUser(@PathVariable("userId") int userId, @RequestBody UserRenameDto userRenameDto) {
        return userService.updateUser(userId, userRenameDto);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }
}
