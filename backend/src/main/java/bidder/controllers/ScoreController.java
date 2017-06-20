package bidder.controllers;

import bidder.model.Score;
import bidder.model.web.request.MatchDetailsRequest;
import bidder.model.web.response.ScoreResponse;
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

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping(path = "")
    public ScoreResponse getAllScores() {
        List<Score> scores = scoreService.getAllScores();
        ScoreResponse response = new ScoreResponse();
        response.setScores(scores);
        return response;
    }

    @GetMapping(path = "/{userId}")
    public ScoreResponse getScoresForUser(@PathVariable String userId) {
        ScoreResponse response = new ScoreResponse();
        response.setScores(scoreService.getScoresForUser(userId));
        return response;
    }

    @PostMapping(path = "")
    public String addScore(@Valid @RequestBody MatchDetailsRequest matchDetailsRequest) {
        Score score = scoreService.addScore(matchDetailsRequest.getCupId(), matchDetailsRequest.getUserId(),
                matchDetailsRequest.getGameId(), matchDetailsRequest.getHomeTeamScore(), matchDetailsRequest.getAwayTeamScore());
        return score.getId();
    }

    @PutMapping(path = "")
    public void changeScore(@Valid @RequestBody MatchDetailsRequest matchDetailsRequest) {
        scoreService.changeScore(matchDetailsRequest.getUserId(), matchDetailsRequest.getScoreId(), matchDetailsRequest.getHomeTeamScore(),
                matchDetailsRequest.getAwayTeamScore());
    }
}
