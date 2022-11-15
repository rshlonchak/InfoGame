package com.example.infogame.dto.user;

import com.example.infogame.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);
    UserResponseDto userResponseFromEntity(User entity);
    User fromEntity(UserCreateDto dto);
    User toEntity(UserUpdateDto dto);
}
