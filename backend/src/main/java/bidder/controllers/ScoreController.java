package bidder.controllers;

import bidder.model.match.Score;
import bidder.model.web.request.ScoreRequest;
import bidder.model.web.response.ScoreResponse;
import bidder.services.GameService;
import bidder.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/** Created by Gawa on 11/06/17.*/
@RestController
@RequestMapping(path = "/api/score")
@CrossOrigin(origins = "*")
public class ScoreController {

    private final ScoreService scoreService;
    private final GameService gameService;

    @Autowired
    public ScoreController(ScoreService scoreService, GameService gameService) {
        this.scoreService = scoreService;
        this.gameService = gameService;
    }

    @GetMapping(path = "/all")
    public ScoreResponse getAllScores() {
        List<Score> scores = scoreService.getAllScores();
        ScoreResponse response = new ScoreResponse();
        response.setScores(scores);
        return response;
    }

    @GetMapping(path = "/all/{userId}")
    public ScoreResponse getScoresForUser(@PathVariable String userId) {
        ScoreResponse response = new ScoreResponse();
        response.setScores(scoreService.getScoresForUser(userId));
        response.setGames(gameService.getGamesToBid(userId));
        return response;
    }

    @PostMapping(path = "/addScore")
    public String addScore(@Valid @RequestBody ScoreRequest scoreRequest) {
        Score score = scoreService.addScore(scoreRequest.getUserId(), scoreRequest.getGameId(), scoreRequest.getHomeTeamScore(),
                scoreRequest.getAwayTeamScore());
        return score.getId();
    }

    @PostMapping(path = "/changeScore")
    public void changeScore(@Valid @RequestBody ScoreRequest scoreRequest) {
        scoreService.changeScore(scoreRequest.getUserId(), scoreRequest.getScoreId(), scoreRequest.getHomeTeamScore(),
                scoreRequest.getAwayTeamScore());
    }
}
