package bidder.controllers;

import bidder.model.web.response.GameResponse;
import bidder.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
