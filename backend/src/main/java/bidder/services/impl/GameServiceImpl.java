package bidder.services.impl;

import bidder.model.match.Game;
import bidder.repositories.GameRepository;
import bidder.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by gawa on 2017-05-08. */
@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Override
	public void dropGames() {
		gameRepository.deleteAll();
	}

	@Override
	public Game addGame(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public List<Game> addAllGames(List<Game> games) {
		return gameRepository.save(games);
	}

	@Override
    public List<Game> getAllGames() {
	    return gameRepository.findAll();
    }
}
