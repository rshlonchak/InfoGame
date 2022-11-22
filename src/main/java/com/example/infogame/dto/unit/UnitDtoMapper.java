package com.example.infogame.dto.unit;

import com.example.infogame.models.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UnitDtoMapper {

    UnitDtoMapper INSTANCE = Mappers.getMapper(UnitDtoMapper.class);
    UnitResponseDto unitResponseFromEntity(Unit entity);
    Unit fromEntity(UnitCreateDto dto);
}
