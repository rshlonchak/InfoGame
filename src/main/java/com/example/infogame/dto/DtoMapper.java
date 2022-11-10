package com.example.infogame.dto;

public interface DtoMapper<T> {
    default T toEntity() { return  null; };
    default DtoMapper<T> fromEntity(T entity) {return null; };
}

