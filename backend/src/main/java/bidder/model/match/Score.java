package bidder.model.match;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by gawa on 06.05.17.
 */
@Document(collection = "scores")
public class Score {

	@Id
	private String id;
	private Game game;
	private int homeTeamScore;
	private int awayTeamScore;
	private List<String> homeTeamScorers;
	private List<String> awayTeamScorers;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getId() {
		return id;
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
