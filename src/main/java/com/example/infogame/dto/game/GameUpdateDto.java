package com.example.infogame.dto.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GameUpdateDto {

    private String name;
    private String description;
}
