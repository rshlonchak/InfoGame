package com.example.infogame.dto.game;

import com.example.infogame.dto.DtoMapper;
import com.example.infogame.models.Game;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameResponseDto implements DtoMapper<Game> {

    private int id;
    private String name;
    private String description;
}
