package bidder.services.impl;

import bidder.model.match.Game;
import bidder.model.match.Score;
import bidder.repositories.ScoreRepository;
import bidder.services.CupService;
import bidder.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public Score addScore(String cupId, String userId, String gameId, int homeTeamScore, int awayTeamScore) {
        Game game = cupService.getGame(cupId, gameId);
        Score score = new Score(userId, game, homeTeamScore, awayTeamScore);
        score = scoreRepository.save(score);
        return score;
    }

    public void changeScore(String userId, String scoreId, int homeTeamScore, int awayTeamScore) {
        Score score = scoreRepository.findOne(scoreId);
        if (score == null) {
            throw new RuntimeException(String.format("Can't find score %s.", scoreId));
        }
        if (!userId.equals(score.getUserId())) {
            throw new RuntimeException(String.format("Score %s belongs to another user.", scoreId));
        }
        score.setHomeTeamScore(homeTeamScore);
        score.setAwayTeamScore(awayTeamScore);
        score.setLastModificationDate(LocalDateTime.now());
    }

    @Override
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public List<Score> getScoresForUser(String userId) {
        return scoreRepository.findByUserId(userId);
    }
}
