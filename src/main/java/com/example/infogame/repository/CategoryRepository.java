package com.example.infogame.repository;


import com.example.infogame.dto.category.CategoryResponseDto;
import com.example.infogame.models.Category;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query("SELECT * FROM categories")
    List<CategoryResponseDto> listCategories();

    @Query("SELECT * FROM categories WHERE id=:itemId")
    Optional<Category> getCategoryById(int itemId);

    @Modifying
    @Query("UPDATE categories SET name=:name, description=:description, image=:image WHERE id=:itemId")
    void updateCategory(int itemId, String name, String description, String image);
}
