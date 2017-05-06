package bidder.repositories;

import bidder.model.Cup;
import org.springframework.data.mongodb.repository.MongoRepository;

/** Created by gawa on 06.05.17. */
public interface CupRepository extends MongoRepository<Cup, String> {
}
