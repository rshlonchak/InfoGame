package com.example.infogame.controllers;

import com.example.infogame.dto.category.CategoryCreateDto;
import com.example.infogame.dto.category.CategoryUpdateDto;
import com.example.infogame.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Categories")
@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping("/categories")
//    public List<CategoryResponseDto> listCategories() {
//        return categoryService.getCategory();
//    }

    @GetMapping()
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getCategory());
        return "category/list";
    }

//    @PostMapping("/categories")
//    public CategoryResponseDto createCategory(@RequestBody CategoryCreateDto categoryCreateDto) {
//        return categoryService.createCategory(categoryCreateDto);
//    }

    @GetMapping("/new")
    public String newCategory(Model model) {
        model.addAttribute("category", new CategoryCreateDto());
        return "category/new";
    }

    @PostMapping()
    public String createCategory(@ModelAttribute CategoryCreateDto categoryCreateDto) {
        categoryService.createCategory(categoryCreateDto);
        return "redirect:/category";
    }

//    @GetMapping("/category/{categoryId}")
//    public CategoryResponseDto getCategory(@PathVariable("categoryId") int categoryId) {
//        return categoryService.getCategoryById(categoryId);
//    }

    @GetMapping("/{categoryId}")
    public String getCategory(@PathVariable("categoryId") int categoryId, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(categoryId));
        return "category/profile";
    }

//    @PutMapping("/category/{categoryId}")
//    public CategoryResponseDto updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody CategoryUpdateDto categoryUpdateDto) {
//        return categoryService.updateCategory(categoryId, categoryUpdateDto);
//    }

    @GetMapping("/{categoryId}/edit")
    public String editCategory(@PathVariable("categoryId") int categoryId, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(categoryId));
        return "category/edit";
    }

    @PutMapping("/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") int categoryId, @ModelAttribute("category") CategoryUpdateDto categoryUpdateDto) {
        categoryService.updateCategory(categoryId, categoryUpdateDto);
        return "redirect:/category/{categoryId}";
    }

//    @DeleteMapping("/category/{categoryId}")
//    public void deleteCategory(@PathVariable("categoryId") int categoryId) {
//        categoryService.deleteCategory(categoryId);
//    }

    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") int categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/category";
    }
}
