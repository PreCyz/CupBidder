package bidder.repositories;

import bidder.model.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/** Created by gawa on 06.05.17. */
public interface ScoreRepository extends MongoRepository<Score, String> {
    List<Score> findByUserId(String userId);
}
