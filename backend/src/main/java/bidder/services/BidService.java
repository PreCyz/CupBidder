package bidder.services;

import bidder.model.Bid;
import bidder.model.match.Game;

import java.util.List;

/** Created by gawa on 06.05.17. */
public interface BidService {
    List<Bid> getBidsForUser(String cupId, String userId);
    List<Game> getGamesToBid(String cupId, String userId);
}
