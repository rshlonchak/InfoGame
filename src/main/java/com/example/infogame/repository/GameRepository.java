package com.example.infogame.repository;


import com.example.infogame.dto.game.GameResponseDto;
import com.example.infogame.models.Game;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("SELECT * FROM games")
    List<GameResponseDto> listGames();
}
