package bidder.repositories;

import bidder.model.match.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/** Created by Gawa on 06.05.17.*/
public interface GameRepository extends MongoRepository<Game, String> {

}
