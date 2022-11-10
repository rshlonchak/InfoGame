package com.example.infogame.dto.user;

import com.example.infogame.dto.DtoMapper;
import com.example.infogame.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto implements DtoMapper<User> {

    private int id;
    private String name;
    private String email;
}
