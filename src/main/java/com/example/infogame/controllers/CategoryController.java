package com.example.infogame.controllers;

import com.example.infogame.dto.category.CategoryCreateDto;
import com.example.infogame.dto.category.CategoryResponseDto;
import com.example.infogame.dto.category.CategoryUpdateDto;
import com.example.infogame.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/category/{categoryId}")
    public CategoryResponseDto getCategory(@PathVariable("categoryId") int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/category/{categoryId}")
    public CategoryResponseDto updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody CategoryUpdateDto categoryUpdateDto) {
        return categoryService.updateCategory(categoryId, categoryUpdateDto);
    }

    @DeleteMapping("/category/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") int categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
