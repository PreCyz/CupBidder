package bidder.repositories;

import bidder.model.Cup;
import bidder.model.CupStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;

/** Created by gawa on 06.05.17. */
public interface CupRepository extends MongoRepository<Cup, String> {
    List<Cup> findByStatusIsIn(Set<CupStatus> statuses);
}
