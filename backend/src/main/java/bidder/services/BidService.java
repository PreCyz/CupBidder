package bidder.services;

import bidder.model.Bid;

import java.util.Set;

/** Created by gawa on 06.05.17. */
public interface BidService {
    Set<Bid> getBidsForUser(String cupId, String userId);
    Bid addBid(String cupId, String userId, String gameId, int homeTeamScore, int awayTeamScore);
    void changeBid(String userId, String bidId, int homeTeamScore, int awayTeamScore);
}
