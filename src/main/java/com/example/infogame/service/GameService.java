package com.example.infogame.service;

import com.example.infogame.dto.game.GameCreateDto;
import com.example.infogame.dto.game.GameDtoMapper;
import com.example.infogame.dto.game.GameResponseDto;
import com.example.infogame.dto.game.GameUpdateDto;
import com.example.infogame.models.Game;
import com.example.infogame.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameService {

    public static final String GAME_NOT_FOUND = "Game not found";
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

    public Game getGameByIdOrNotFound(int gameId) throws ItemNotFoundException {
        Optional<Game> gameOptional = gameRepository.getGameById(gameId);
        if (gameOptional.isEmpty()) throw new ItemNotFoundException(GAME_NOT_FOUND);
        return gameOptional.get();
    }

    public GameResponseDto getGameById(int gameId) {
        Game game = getGameByIdOrNotFound(gameId);
        return GameDtoMapper.INSTANCE.gameResponseFromEntity(game);
    }

    public GameResponseDto updateGame(int gameId, GameUpdateDto gameUpdateDto) {
        Game game = getGameByIdOrNotFound(gameId);
        try {
            updateGame(gameId, gameUpdateDto, game);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return GameDtoMapper.INSTANCE.gameResponseFromEntity(getGameByIdOrNotFound(gameId));
    }

    private void updateGame(int gameId, GameUpdateDto gameUpdateDto, Game game) {
        String name = Objects.isNull(gameUpdateDto.getName()) ? game.getName() : gameUpdateDto.getName();
        String description = Objects.isNull(gameUpdateDto.getDescription()) ? game.getDescription() : gameUpdateDto.getDescription();
        gameRepository.updateGame(gameId, name, description);
    }

    public void deleteGame(int gameId) {
        Game game = getGameByIdOrNotFound(gameId);
        gameRepository.deleteById(game.getId());
    }

}
