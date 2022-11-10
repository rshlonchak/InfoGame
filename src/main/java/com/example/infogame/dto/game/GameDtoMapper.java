package com.example.infogame.dto.game;

import com.example.infogame.models.Game;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GameDtoMapper {

    GameDtoMapper INSTANCE = Mappers.getMapper(GameDtoMapper.class);
    GameResponseDto gameResponseFromEntity(Game entity);
    Game fromEntity(GameCreateDto dto);
}
