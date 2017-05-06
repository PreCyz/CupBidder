package bidder.repositories;

import bidder.model.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;

/** Created by gawa on 06.05.17. */
public interface BidRepository extends MongoRepository<Bid, String> {
}
