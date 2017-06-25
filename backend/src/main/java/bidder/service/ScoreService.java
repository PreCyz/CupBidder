package bidder.service;

import bidder.model.Score;

import java.util.Set;

/** Created by gawa on 06.05.17. */
public interface ScoreService {
    Score addScore(String cupId, String gameId, int homeTeamScore, int awayTeamScore);
    void changeScore(String scoreId, int homeTeamScore, int awayTeamScore);
    Set<Score> getAllScores();
    Set<Score> getScoresForCup(String userId);
}
