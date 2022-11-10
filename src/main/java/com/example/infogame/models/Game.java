package com.example.infogame.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("games")
public class Game {

    @Id
    @Column("id")
    private int id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;
}
