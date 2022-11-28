package com.example.infogame.service;

import com.example.infogame.dto.category.CategoryCreateDto;
import com.example.infogame.dto.category.CategoryDtoMapper;
import com.example.infogame.dto.category.CategoryResponseDto;
import com.example.infogame.dto.category.CategoryUpdateDto;
import com.example.infogame.models.Category;
import com.example.infogame.repository.CategoryRepository;
import com.example.infogame.validation.DtoValidator;
import com.example.infogame.validation.DtoValidatorImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {

    public static final String CATEGORY_NOT_FOUND = "Category not found";

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponseDto> getCategory() {
        return categoryRepository.listCategories();
    }

    public CategoryResponseDto createCategory(CategoryCreateDto categoryCreateDto) {
        DtoValidator<CategoryCreateDto> validator = new DtoValidatorImpl<>();
        validator.validate(categoryCreateDto);

        Category category = categoryRepository.save(CategoryDtoMapper.INSTANCE.fromEntity(categoryCreateDto));
        return CategoryDtoMapper.INSTANCE.categoryResponseFromEntity(category);
    }

    public Category getCategoryByIdOrNotFound(int categoryId) throws ItemNotFoundException {
        Optional<Category> categoryOptional = categoryRepository.getCategoryById(categoryId);
        if (categoryOptional.isEmpty()) throw new ItemNotFoundException(CATEGORY_NOT_FOUND);
        return categoryOptional.get();
    }

    public CategoryResponseDto getCategoryById(int categoryId) {
        Category category = getCategoryByIdOrNotFound(categoryId);
        return CategoryDtoMapper.INSTANCE.categoryResponseFromEntity(category);
    }

    public CategoryResponseDto updateCategory(int categoryId, CategoryUpdateDto categoryUpdateDto) {
        DtoValidator<CategoryUpdateDto> validator = new DtoValidatorImpl<>();
        validator.validate(categoryUpdateDto);

        Category category = getCategoryByIdOrNotFound(categoryId);
        try {
            updateCategory(categoryId, categoryUpdateDto, category);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return CategoryDtoMapper.INSTANCE.categoryResponseFromEntity(getCategoryByIdOrNotFound(categoryId));
    }

    private void updateCategory(int categoryId, CategoryUpdateDto categoryUpdateDto, Category category) {
        String name = Objects.isNull(categoryUpdateDto.getName()) ? category.getName() : categoryUpdateDto.getName();
        String description = Objects.isNull(categoryUpdateDto.getDescription()) ? category.getDescription() : categoryUpdateDto.getDescription();
        String image = Objects.isNull(categoryUpdateDto.getImage()) ? category.getImage() : categoryUpdateDto.getImage();
        categoryRepository.updateCategory(categoryId, name, description, image);
    }

    public void deleteCategory(int categoryId) {
        Category category = getCategoryByIdOrNotFound(categoryId);
        categoryRepository.deleteById(category.getId());
    }
}
