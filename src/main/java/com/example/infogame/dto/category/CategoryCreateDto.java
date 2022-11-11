package com.example.infogame.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCreateDto {

    @NotNull(message = "Empty name does not performed")
    private String name;

    private String description;
    private String image;
}
