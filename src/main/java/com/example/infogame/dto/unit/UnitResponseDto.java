package com.example.infogame.dto.unit;

import com.example.infogame.dto.DtoMapper;
import com.example.infogame.models.Unit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitResponseDto implements DtoMapper<Unit> {

    private int id;
    private String name;
    private String description;
    private String image;
}
