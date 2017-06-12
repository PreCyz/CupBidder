package bidder.controllers;

import bidder.model.web.response.GameResponse;
import bidder.services.GameService;
import bidder.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** Created by Gawa on 26/05/17.*/
@RestController
@RequestMapping(path = "/api/game")
@CrossOrigin(origins = "*")
public class GameController {

    private final GameService gameService;
    private final ScoreService scoreService;

    @Autowired
    public GameController(GameService gameService, ScoreService scoreService) {
        this.gameService = gameService;
        this.scoreService = scoreService;
    }

    @GetMapping(path = "/all")
    public GameResponse allGames() {
        GameResponse response = new GameResponse();
        response.setGames(gameService.getAllGames());
        return response;
    }

    @GetMapping(path = "/all/{userId}")
    public GameResponse getGamesToBid(@PathVariable(name = "userId") String userId) {
        GameResponse response = new GameResponse();
        response.setGames(gameService.getAllGames());
        return response;
    }
}
