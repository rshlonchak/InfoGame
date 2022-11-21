package com.example.infogame.controllers;

import com.example.infogame.dto.game.GameCreateDto;
import com.example.infogame.dto.game.GameUpdateDto;
import com.example.infogame.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Games")
@Controller
@RequestMapping()
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

//    @GetMapping("/games")
//    public List<GameResponseDto> listGames() {
//        return gameService.getGames();
//    }

    @GetMapping()
    public String listGames(Model model) {
        model.addAttribute("games", gameService.getGames());
        return "game/list";
    }

//    @PostMapping("/games")
//    public GameResponseDto createGame(@RequestBody GameCreateDto gameCreateDto) {
//        return gameService.createGame(gameCreateDto);
//    }

    @GetMapping("game/new")
    public String newGame(Model model) {
        model.addAttribute("game", new GameCreateDto());
        return "game/new";
    }

    @PostMapping()
    public String createGame(@ModelAttribute GameCreateDto gameCreateDto) {
        gameService.createGame(gameCreateDto);
        return "redirect:/";
    }

//    @GetMapping("/game/{gameId}")
//    public GameResponseDto getGame(@PathVariable("gameId") int gameId) {
//        return gameService.getGameById(gameId);
//    }

    @GetMapping("/game/{gameId}")
    public String getGame(@PathVariable("gameId") int gameId, Model model) {
        model.addAttribute("game", gameService.getGameById(gameId));
        return "game/profile";
    }

//    @PutMapping("/game/{gameId}")
//    public GameResponseDto updateGame(@PathVariable("gameId") int gameId, @RequestBody GameUpdateDto gameUpdateDto) {
//        return gameService.updateGame(gameId, gameUpdateDto);
//    }

    @GetMapping("/game/{gameId}/edit")
    public String editGame(@PathVariable("gameId") int gameId, Model model) {
        model.addAttribute("game", gameService.getGameById(gameId));
        return "game/edit";
    }

    @PutMapping("/game/{gameId}")
    public String updateGame(@PathVariable("gameId") int gameId, @ModelAttribute("game") GameUpdateDto gameUpdateDto) {
        gameService.updateGame(gameId, gameUpdateDto);
        return "redirect:/game/{gameId}";
    }

//    @DeleteMapping("/game/{gameId}")
//    public void deleteGame(@PathVariable("gameId") int gameId) {
//        gameService.deleteGame(gameId);
//    }

    @DeleteMapping("/game/{gameId}")
    public String deleteGame(@PathVariable("gameId") int gameId) {
        gameService.deleteGame(gameId);
        return "redirect:/";
    }
}
