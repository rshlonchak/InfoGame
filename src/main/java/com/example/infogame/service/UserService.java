package com.example.infogame.service;

import com.example.infogame.dto.user.UserCreateDto;
import com.example.infogame.dto.user.UserDtoMapper;
import com.example.infogame.dto.user.UserResponseDto;
import com.example.infogame.models.User;
import com.example.infogame.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getUsers() {
        return userRepository.listUsers();
    }

    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        User user = userRepository.save(UserDtoMapper.INSTANCE.fromEntity(userCreateDto));
        return UserDtoMapper.INSTANCE.userResponseFromEntity(user);
    }
}
