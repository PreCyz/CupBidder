package bidder.controllers;

import bidder.model.web.request.ScoreRequest;
import bidder.model.web.response.GameResponse;
import bidder.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/** Created by Gawa on 26/05/17.*/
@RestController
@RequestMapping(path = "/api/game")
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(path = "/all")
    public GameResponse allGames() {
        GameResponse response = new GameResponse();
        response.setGames(gameService.getAllGames());
        return response;
    }

    @PostMapping(path = "/addScore")
    public void addScore(@Valid @RequestBody ScoreRequest scoreRequest) {
        scoreRequest.getGameId();
        scoreRequest.getHomeTeamScore();
    }
}
