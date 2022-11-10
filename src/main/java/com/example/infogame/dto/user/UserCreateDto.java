package com.example.infogame.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto {

    @NotNull(message = "Empty name does not performed")
    private String name;

    @NotNull(message = "Empty email does not performed")
    private String email;
}
