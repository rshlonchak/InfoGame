package com.example.infogame.controllers;

import com.example.infogame.dto.user.UserCreateDto;
import com.example.infogame.dto.user.UserUpdateDto;
import com.example.infogame.models.User;
import com.example.infogame.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name="Users")
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/users")
//    public List<UserResponseDto> listUsers() {
//        return userService.getUsers();
//    }

    @GetMapping()
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "user/list";
    }

//    @PostMapping("/users")
//    public UserResponseDto createUser(@RequestBody UserCreateDto userCreateDto) {
//        return userService.createUser(userCreateDto);
//    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new UserCreateDto());
        return "user/new";
    }

    @PostMapping()
    public String createUser(
            @ModelAttribute("UserCreateDto") @Valid UserCreateDto userCreateDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            return "user/new";

        userService.createUser(userCreateDto);
        return "redirect:/users";
    }

//    @GetMapping("/user/{userId}")
//    public UserResponseDto getUser(@PathVariable("userId") int userId) {
//        return userService.getUserById(userId);
//    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable("userId") int userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "user/profile";
    }

//    @PutMapping("/{userId}")
//    public UserResponseDto updateUser(@PathVariable("userId") int userId, @RequestBody UserUpdateDto userUpdateDto) {
//        return userService.updateUser(userId, userUpdateDto);
//    }

    @GetMapping("/{userId}/edit")
    public String editUser(
            @PathVariable("userId") int userId,
            Model model
    ) {
        model.addAttribute("user", userService.getUserById(userId));
        return "user/edit";
    }

    @PostMapping("/{userId}")
    public String updateUser(
            @PathVariable("userId") int userId,
            @ModelAttribute("UserUpdateDto") @Valid UserUpdateDto userUpdateDto,
            BindingResult bindingResult
            ) {
        if (bindingResult.hasErrors())
            return "user/edit";

        userService.updateUser(userId, userUpdateDto);
        return "redirect:/users/{userId}";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }
}
