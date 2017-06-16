package bidder.services.impl;

import bidder.model.Bid;
import bidder.repositories.BidRepository;
import bidder.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by Gawa on 16/06/17.*/
@Service
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;

    @Autowired
    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public List<Bid> getBidsForUser(String cupId, String userId) {
        return bidRepository.findByCupIdAndUserId(cupId, userId);
    }
}
