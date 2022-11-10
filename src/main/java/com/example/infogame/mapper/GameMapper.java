package com.example.infogame.mapper;

import com.example.infogame.models.Game;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GameMapper implements RowMapper<Game> {

    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setId(rs.getInt("id"));
        game.setName(rs.getString("name"));
        game.setDescription(rs.getString("description"));
        return game;
    }
}
