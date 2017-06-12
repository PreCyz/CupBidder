package bidder.services.impl;

import bidder.model.match.Game;
import bidder.model.match.Score;
import bidder.repositories.GameRepository;
import bidder.repositories.ScoreRepository;
import bidder.services.GameService;
import bidder.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/** Created by gawa on 2017-05-08. */
@Service
public class GameServiceImpl implements GameService {

	private final GameRepository gameRepository;

	@Autowired
	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

    @Override
    public Game getGame(String gameId) {
		Game game = gameRepository.findOne(gameId);
		if (game == null) {
			throw new RuntimeException(String.format("Can't find the game with id %s.", gameId));
		}
		return game;
    }

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

    @Override
    public List<Game> getGamesToBid(String userId) {
        return null;
    }
}
