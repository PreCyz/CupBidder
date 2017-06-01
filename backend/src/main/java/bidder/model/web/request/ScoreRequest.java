package bidder.model.web.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

/** Created by Gawa on 01/06/17.*/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ScoreRequest {

    @NotNull
    private String userId;
    @NotNull
    private String gameId;
    @NotNull
    private int homeTeamScore;
    @NotNull
    private int awayTeamScore;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }
}
