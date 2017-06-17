package bidder.model.web.response;

import bidder.model.match.Game;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/** Created by Gawa on 25/05/17.*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GamesToBidResponse {

    private List<Game> games;

    public GamesToBidResponse(List<Game> games) {
        this.games = games;
    }

    public List<Game> getGames() {
        return games;
    }
}
