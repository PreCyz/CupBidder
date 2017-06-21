package bidder.model;

import bidder.model.common.CommonAttributes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/** Created by gawa on 06.05.17. */
@Document(collection = "scores")
public class Score extends CommonAttributes {

	@NotNull
	private String cupId;
	@NotNull
	private Game game;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	private List<String> homeTeamScorers;
	private List<String> awayTeamScorers;

	public Score() {}

	public Score(String cupId, Game game, Integer homeTeamScore, Integer awayTeamScore) {
		this.cupId = cupId;
		this.game = game;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.creationDate = LocalDateTime.now();
	}

	public String getCupId() {
		return cupId;
	}

	public void setCupId(String cupId) {
		this.cupId = cupId;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(Integer awayTeamScore) {
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
