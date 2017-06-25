package bidder.repositorie;

import bidder.model.user.Bidder;
import bidder.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/** Created by gawa on 01.05.17. */
public interface UserRepository extends MongoRepository<User, String> {
	User findByLastName(String lastName);
	User findById(String id);
	User findByEmail(String email);
	Bidder findByNickname(String nickname);
	List<? extends User> findByType(String type);
}
