package bidder.model.web.response;

import bidder.model.match.Game;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Size;
import java.util.List;

/** Created by Gawa on 25/05/17.*/
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class GameResponse {

    @Size(min = 1)
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
