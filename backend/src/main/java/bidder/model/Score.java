package bidder.model;

import bidder.model.Game;
import bidder.model.common.CommonAttributes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/** Created by gawa on 06.05.17. */
@Document(collection = "scores")
public class Score extends CommonAttributes {

	protected String cupId;
	protected String userId;
	protected Game game;
	protected int homeTeamScore;
	protected int awayTeamScore;
	protected List<String> homeTeamScorers;
	protected List<String> awayTeamScorers;

	public Score() {}

	public Score(String cupId, String userId, Game game, int homeTeamScore, int awayTeamScore) {
		this.cupId = cupId;
		this.userId = userId;
		this.game = game;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.creationDate = LocalDateTime.now();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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

	public List<String> getHomeTeamScorers() {
		return homeTeamScorers;
	}

	public void setHomeTeamScorers(List<String> homeTeamScorers) {
		this.homeTeamScorers = homeTeamScorers;
	}

	public List<String> getAwayTeamScorers() {
		return awayTeamScorers;
	}

	public void setAwayTeamScorers(List<String> awayTeamScorers) {
		this.awayTeamScorers = awayTeamScorers;
	}
}
