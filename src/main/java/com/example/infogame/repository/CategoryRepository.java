package com.example.infogame.repository;


import com.example.infogame.dto.category.CategoryResponseDto;
import com.example.infogame.models.Category;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query("SELECT * FROM categories")
    List<CategoryResponseDto> listCategories();
}
