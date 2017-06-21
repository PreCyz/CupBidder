package bidder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/** Created by gawa on 01.05.17.*/
@Document(collection = "bids")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Bid extends Score {

    @NotNull
    private String userId;
    @Transient
    private boolean available;

    public Bid() {
        super();
    }

    public Bid(String cupId, Game game, Integer homeTeamScore, Integer awayTeamScore, String userId) {
        super(cupId, game, homeTeamScore, awayTeamScore);
        this.userId = userId;
    }

    public Bid(String cupId, Game game, String userId) {
        this(cupId, game, null, null, userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
