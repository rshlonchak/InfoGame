package com.example.infogame.repository;


import com.example.infogame.dto.game.GameResponseDto;
import com.example.infogame.models.Game;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("SELECT * FROM games")
    List<GameResponseDto> listGames();

    @Query("SELECT * FROM games WHERE id=:itemId")
    Optional<Game> getGameById(int itemId);

    @Modifying
    @Query("UPDATE games SET name=:name, description=:description WHERE id=:itemId")
    void updateGame(int itemId, String name, String description);
}
