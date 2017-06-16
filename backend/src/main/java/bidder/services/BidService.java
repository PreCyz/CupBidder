package bidder.services;

import bidder.model.Bid;

import java.util.List;

/** Created by gawa on 06.05.17. */
public interface BidService {
    List<Bid> getBidsForUser(String cupId, String userId);
}
