package bidder.services.impl;

import bidder.model.Bid;
import bidder.model.Cup;
import bidder.model.match.Game;
import bidder.model.match.Score;
import bidder.repositories.BidRepository;
import bidder.services.BidService;
import bidder.services.CupService;
import bidder.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by Gawa on 16/06/17.*/
@Service
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final CupService cupService;
    private final ScoreService scoreService;

    @Autowired
    public BidServiceImpl(BidRepository bidRepository, CupService cupService, ScoreService scoreService) {
        this.bidRepository = bidRepository;
        this.cupService = cupService;
        this.scoreService = scoreService;
    }

    @Override
    public List<Bid> getBidsForUser(String cupId, String userId) {
        return bidRepository.findByCupIdAndUserId(cupId, userId);
    }

    @Override
    public List<Game> getGamesToBid(String cupId, String userId) {
        List<Score> scores = scoreService.getScoresForUser(userId);
        Cup cup = cupService.getCup(cupId);
        if (scores == null || scores.isEmpty()) {
            return cup.getGames();
        }
        //TODO: filter out games from cup, from games from scores
        return cup.getGames();
    }
}
