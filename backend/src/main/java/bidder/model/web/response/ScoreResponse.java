package bidder.model.web.response;

import bidder.model.Score;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

/** Created by Gawa on 12/06/17.*/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ScoreResponse {

    private Set<Score> scores;

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

}
