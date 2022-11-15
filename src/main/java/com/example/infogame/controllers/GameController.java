package com.example.infogame.controllers;

import com.example.infogame.dto.game.GameCreateDto;
import com.example.infogame.dto.game.GameResponseDto;
import com.example.infogame.dto.game.GameUpdateDto;
import com.example.infogame.dto.user.UserResponseDto;
import com.example.infogame.dto.user.UserUpdateDto;
import com.example.infogame.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Games")
@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<GameResponseDto> listGames() {
        return gameService.getGames();
    }

    @PostMapping("/games")
    public GameResponseDto createGame(@RequestBody GameCreateDto gameCreateDto) {
        return gameService.createGame(gameCreateDto);
    }

    @GetMapping("/game/{gameId}")
    public GameResponseDto getGame(@PathVariable("gameId") int gameId) {
        return gameService.getGameById(gameId);
    }

    @PutMapping("/game/{gameId}")
    public GameResponseDto updateGame(@PathVariable("gameId") int gameId, @RequestBody GameUpdateDto gameUpdateDto) {
        return gameService.updateGame(gameId, gameUpdateDto);
    }

    @DeleteMapping("/game/{gameId}")
    public void deleteGame(@PathVariable("gameId") int gameId) {
        gameService.deleteGame(gameId);
    }
}
