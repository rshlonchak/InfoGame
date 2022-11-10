package com.example.infogame.controllers;

import com.example.infogame.dto.game.GameCreateDto;
import com.example.infogame.dto.game.GameResponseDto;
import com.example.infogame.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
