package bidder.services.impl;

import bidder.model.Bid;
import bidder.model.Cup;
import bidder.model.Game;
import bidder.model.comparator.ScoreComparator;
import bidder.repositories.BidRepository;
import bidder.services.BidService;
import bidder.services.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/** Created by Gawa on 16/06/17.*/
@Service
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final CupService cupService;

    @Autowired
    public BidServiceImpl(BidRepository bidRepository, CupService cupService) {
        this.bidRepository = bidRepository;
        this.cupService = cupService;
    }

    @Override
    public Set<Bid> getBidsForUser(String cupId, String userId) {
        List<Bid> bids = bidRepository.findByCupIdAndUserId(cupId, userId);
        Set<String> existingBids = bids.stream().map(bid -> bid.getGame().getId()).collect(Collectors.toSet());

        Cup cup = cupService.getCup(cupId);
        Set<Bid> result = new TreeSet<>(ScoreComparator.getInstance());
        result.addAll(bids);
        final LocalDateTime now = LocalDateTime.now();
        cup.getGames().forEach(game -> {
            if (!existingBids.contains(game.getId())) {
                result.add(new Bid(cupId, game, userId));
            }
        });

        result.forEach(bid -> bid.setAvailable(now.isBefore(bid.getGame().getStartDateTime())));
        return result;
    }

    @Override
    public Bid addBid(String cupId, String userId, String gameId, int homeTeamScore, int awayTeamScore) {
        Game game = cupService.getGameFromCup(cupId, gameId);
        Bid bid = bidRepository.insert(new Bid(cupId, game, homeTeamScore, awayTeamScore, userId));
        return bid;
    }

    @Override
    public void changeBid(String userId, String bidId, int homeTeamScore, int awayTeamScore) {
        Bid bid = bidRepository.findOne(bidId);
        if (bid == null) {
            throw new RuntimeException(String.format("Can't find bid %s for user %s.", bidId, userId));
        }
        if (!userId.equals(bid.getUserId())) {
            throw new RuntimeException(String.format("Bid %s belongs to another user.", bidId));
        }
        bid.setHomeTeamScore(homeTeamScore);
        bid.setAwayTeamScore(awayTeamScore);
        bid.setLastModificationDate(LocalDateTime.now());
        bidRepository.save(bid);
    }

}
