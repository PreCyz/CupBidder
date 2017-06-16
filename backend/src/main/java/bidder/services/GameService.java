package bidder.services;

import bidder.model.match.Game;

import javax.validation.constraints.NotNull;
import java.util.List;

/** Created by gawa on 06.05.17. */
public interface GameService {
	Game getGame(String gameId);
	void dropGames();
	Game addGame(Game game);
	List<Game> addAllGames(List<Game> games);
	List<Game> getAllGames();
	List<Game> getGamesToBid(String cupId, String userId);
}
