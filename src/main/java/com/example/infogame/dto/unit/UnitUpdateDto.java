package com.example.infogame.dto.unit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UnitUpdateDto {

    private String name;
    private String description;
    private String image;
}
