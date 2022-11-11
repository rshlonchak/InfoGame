package com.example.infogame.service;

import com.example.infogame.dto.category.CategoryCreateDto;
import com.example.infogame.dto.category.CategoryDtoMapper;
import com.example.infogame.dto.category.CategoryResponseDto;
import com.example.infogame.models.Category;
import com.example.infogame.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponseDto> getCategory() {
        return categoryRepository.listCategories();
    }

    public CategoryResponseDto createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = categoryRepository.save(CategoryDtoMapper.INSTANCE.fromEntity(categoryCreateDto));
        return CategoryDtoMapper.INSTANCE.categoryResponseFromEntity(category);
    }
}
