package bidder.services;

import bidder.model.Cup;
import bidder.model.match.Game;

import java.util.List;

/** Created by gawa on 06.05.17. */
public interface CupService {
	void dropCups();
	Cup addCup(Cup cup);
    List<Cup> getAllCups();
	void updateCup(String cupId, String name);
	List<Game> getGamesToBid(String cupId, String userId);
	Game getGame(String cupId, String gameId);
	List<Cup> getActiveCups();
}
