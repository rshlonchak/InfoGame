package com.example.infogame.dto.category;

import com.example.infogame.dto.DtoMapper;
import com.example.infogame.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDto implements DtoMapper<Category> {

    private int id;
    private String name;
    private String description;
    private String image;
}
