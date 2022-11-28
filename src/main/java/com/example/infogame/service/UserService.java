package com.example.infogame.service;

import com.example.infogame.dto.user.UserCreateDto;
import com.example.infogame.dto.user.UserDtoMapper;
import com.example.infogame.dto.user.UserResponseDto;
import com.example.infogame.dto.user.UserUpdateDto;
import com.example.infogame.models.User;
import com.example.infogame.repository.UserRepository;
import com.example.infogame.validation.DtoValidator;
import com.example.infogame.validation.DtoValidatorImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        DtoValidator<UserCreateDto> validator = new DtoValidatorImpl<>();
        validator.validate(userCreateDto);

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

    public UserResponseDto updateUser(int userId, UserUpdateDto userUpdateDto) {
        DtoValidator<UserUpdateDto> validator = new DtoValidatorImpl<>();
        validator.validate(userUpdateDto);

        User user = getUserByIdOrNotFound(userId);
        try {
            updateUser(userId, userUpdateDto, user);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return UserDtoMapper.INSTANCE.userResponseFromEntity(getUserByIdOrNotFound(userId));
    }

    private void updateUser(int userId, UserUpdateDto userUpdateDto, User user) {
        String name = Objects.isNull(userUpdateDto.getName()) ? user.getName() : userUpdateDto.getName();
        String email = Objects.isNull(userUpdateDto.getEmail()) ? user.getEmail() : userUpdateDto.getEmail();
        userRepository.updateUser(userId, name, email);
    }

    public void deleteUser(int userId) {
        User user = getUserByIdOrNotFound(userId);
        userRepository.deleteById(user.getId());
    }
}
