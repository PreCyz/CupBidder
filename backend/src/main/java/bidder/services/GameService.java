package bidder.services;

import bidder.model.match.Game;

import java.util.List;

/** Created by gawa on 06.05.17. */
public interface GameService {

	void dropGames();
	Game addGame(Game game);
	List<Game> addAllGames(List<Game> games);
	List<Game> getAllGames();

}
