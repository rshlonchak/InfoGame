package com.example.infogame.dto.category;

import com.example.infogame.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {

    CategoryDtoMapper INSTANCE = Mappers.getMapper(CategoryDtoMapper.class);
    CategoryResponseDto categoryResponseFromEntity(Category entity);
    Category fromEntity(CategoryCreateDto dto);
}
