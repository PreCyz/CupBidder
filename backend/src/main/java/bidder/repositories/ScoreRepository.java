package bidder.repositories;

import bidder.model.match.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

/** Created by gawa on 06.05.17. */
public interface ScoreRepository extends MongoRepository<Score, String> {
}
