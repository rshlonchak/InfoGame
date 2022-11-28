package com.example.infogame.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserUpdateDto {
    @Size(min = 3, max = 25, message = "Name must be longer than 3 characters and less than 25 characters")
    @NotNull(message = "Empty name does not performed.")
    private String name;

    @Size(min = 7, max = 50, message = "Email must be longer than 7 characters and less than 50 characters")
    @Email(message = "Valid email required")
    @NotNull(message = "Empty email does not performed.")
    private String email;
}
