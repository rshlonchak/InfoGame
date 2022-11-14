package com.example.infogame.service;

import com.example.infogame.dto.user.UserCreateDto;
import com.example.infogame.dto.user.UserDtoMapper;
import com.example.infogame.dto.user.UserResponseDto;
import com.example.infogame.dto.user.UserRenameDto;
import com.example.infogame.models.User;
import com.example.infogame.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public static final String USER_NOT_FOUND = "User not found";
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

    public User getUserByIdOrNotFound(int userId) throws ItemNotFoundException {
        Optional<User> userOptional = userRepository.getUserById(userId);
        if (userOptional.isEmpty()) throw new ItemNotFoundException(USER_NOT_FOUND);
        return userOptional.get();
    }

    public UserResponseDto getUserById(int userId) {
        User user = getUserByIdOrNotFound(userId);
        return UserDtoMapper.INSTANCE.userResponseFromEntity(user);
    }

    public UserResponseDto updateUser(int userId, UserRenameDto userRenameDto) {
        getUserByIdOrNotFound(userId);
        userRepository.renameUser(userId, userRenameDto.getName());
        return UserDtoMapper.INSTANCE.userResponseFromEntity(getUserByIdOrNotFound(userId));
    }

    public void deleteUser(int userId) {
        User user = getUserByIdOrNotFound(userId);
        userRepository.deleteById(user.getId());
    }
}
