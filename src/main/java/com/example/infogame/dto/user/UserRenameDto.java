package com.example.infogame.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRenameDto {
    @NotNull(message = "Empty name does not performed.")
    private String name;
}
