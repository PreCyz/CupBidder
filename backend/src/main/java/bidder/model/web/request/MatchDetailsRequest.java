package bidder.model.web.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

/** Created by Gawa on 01/06/17.*/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MatchDetailsRequest {

    @NotNull
    private String cupId;
    @NotNull
    private int homeTeamScore;
    @NotNull
    private int awayTeamScore;

    private String userId;
    private String gameId;
    private String scoreId;
    private String bidId;

    public String getCupId() {
        return cupId;
    }

    public String getUserId() {
        return userId;
    }

    public String getGameId() {
        return gameId;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public String getScoreId() {
        return scoreId;
    }

    public String getBidId() {
        return bidId;
    }
}
