package bidder.services.impl;

import bidder.model.Cup;
import bidder.model.CupStatus;
import bidder.model.match.Game;
import bidder.repositories.CupRepository;
import bidder.services.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Created by gawa on 2017-05-08. */
@Service
public class CupServiceImpl implements CupService {

	private final CupRepository cupRepository;

	@Autowired
	public CupServiceImpl(CupRepository cupRepository) {
		this.cupRepository = cupRepository;
	}

	@Override
	public void dropCups() {
		cupRepository.deleteAll();
	}

	@Override
	public Cup addCup(Cup cup) {
		return cupRepository.save(cup);
	}

	@Override
	public List<Cup> getAllCups() {
		return cupRepository.findAll();
	}

    @Override
    public void updateCup(String cupId, String name) {
        Cup cup = cupRepository.findOne(cupId);
        cup.setName(name);
        cup.setLastModificationDate(LocalDateTime.now());
        cupRepository.save(cup);
    }

    @Override
    public Game getGameFromCup(String cupId, String gameId) {
		if (cupId == null || cupId.isEmpty()) {
			throw new RuntimeException("CupId needs to be given.");
		}
		if(gameId == null || gameId.isEmpty()) {
			throw new RuntimeException("GameId needs to be given.");
		}

		Cup cup = getCup(cupId);
		List<Game> games = cup.getGames().stream().filter(game -> gameId.equals(game.getId())).collect(Collectors.toList());
		if (games == null || games.isEmpty()) {
			throw new RuntimeException(String.format("There is no game with id %s.", gameId));
		}
		if (games.size() > 1) {
			throw new RuntimeException(String.format("There is no more than one game with id %s.", gameId));
		}
		return games.get(0);
    }

    @Override
    public List<Cup> getActiveCups() {
		Set<CupStatus> statuses = Stream.of(CupStatus.New, CupStatus.Running).collect(Collectors.toSet());
		return cupRepository.findByStatusIsIn(statuses);
    }

	@Override
	public Cup getCup(String cupId) {
		Cup cup = cupRepository.findOne(cupId);
		if (cup == null) {
			throw new RuntimeException(String.format("There is no cup with id %s.", cupId));
		}
		return cup;
	}
}
