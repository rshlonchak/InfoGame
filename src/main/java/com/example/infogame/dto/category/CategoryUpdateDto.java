package com.example.infogame.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryUpdateDto {

    private String name;
    private String description;
    private String image;
}
