package bidder.model.web.response;

import bidder.model.Game;
import bidder.model.Score;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/** Created by Gawa on 12/06/17.*/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ScoreResponse {

    private List<Score> scores;
    private List<Game> games;

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
