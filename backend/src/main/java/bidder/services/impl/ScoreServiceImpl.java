package bidder.services.impl;

import bidder.model.Game;
import bidder.model.Score;
import bidder.model.comparator.ScoreComparator;
import bidder.repositories.ScoreRepository;
import bidder.services.CupService;
import bidder.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

/** Created by Gawa on 11/06/17.*/
@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final CupService cupService;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository, CupService cupService) {
        this.scoreRepository = scoreRepository;
        this.cupService = cupService;
    }

    @Override
    public Score addScore(String cupId, String gameId, int homeTeamScore, int awayTeamScore) {
        Game game = cupService.getGameFromCup(cupId, gameId);
        Score score = scoreRepository.insert(new Score(cupId, game, homeTeamScore, awayTeamScore));
        return score;
    }

    public void changeScore(String scoreId, int homeTeamScore, int awayTeamScore) {
        Score score = scoreRepository.findOne(scoreId);
        if (score == null) {
            throw new RuntimeException(String.format("Can't find score %s.", scoreId));
        }
        score.setHomeTeamScore(homeTeamScore);
        score.setAwayTeamScore(awayTeamScore);
        score.setLastModificationDate(LocalDateTime.now());
    }

    @Override
    public Set<Score> getAllScores() {
        Set<Score> cups = new TreeSet<>(ScoreComparator.getInstance());
        cups.addAll(scoreRepository.findAll());
        return cups;
    }

    @Override
    public Set<Score> getScoresForCup(String cupId) {
        Set<Score> cups = new TreeSet<>(ScoreComparator.getInstance());
        cups.addAll(scoreRepository.findByCupId(cupId));
        return cups;
    }
}
