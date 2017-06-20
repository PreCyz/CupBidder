package bidder.services;

import bidder.model.Score;

import java.util.List;

/** Created by gawa on 06.05.17. */
public interface ScoreService {
    Score addScore(String cupId, String userId, String gameId, int homeTeamScore, int awayTeamScore);
    void changeScore(String userId, String scoreId, int homeTeamScore, int awayTeamScore);
    List<Score> getAllScores();
    List<Score> getScoresForUser(String userId);
}
