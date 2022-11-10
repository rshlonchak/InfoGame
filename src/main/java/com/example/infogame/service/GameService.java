package com.example.infogame.service;

import com.example.infogame.dto.game.GameCreateDto;
import com.example.infogame.dto.game.GameDtoMapper;
import com.example.infogame.dto.game.GameResponseDto;
import com.example.infogame.models.Game;
import com.example.infogame.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameResponseDto> getGames() {
        return gameRepository.listGames();
    }

    public GameResponseDto createGame(GameCreateDto gameCreateDto) {
        Game game = gameRepository.save(GameDtoMapper.INSTANCE.fromEntity(gameCreateDto));
        return GameDtoMapper.INSTANCE.gameResponseFromEntity(game);
    }
}
