package com.example.infogame.controllers;

import com.example.infogame.dto.category.CategoryCreateDto;
import com.example.infogame.dto.category.CategoryResponseDto;
import com.example.infogame.dto.game.GameCreateDto;
import com.example.infogame.dto.game.GameResponseDto;
import com.example.infogame.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryResponseDto> listCategories() {
        return categoryService.getCategory();
    }

    @PostMapping("/categories")
    public CategoryResponseDto createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
        return categoryService.createCategory(categoryCreateDto);
    }
}
