package bidder.services;

import bidder.model.users.*;

import java.util.List;

/** Created by gawa on 01.05.17. */
public interface UserService {
	List<User> getAllUsers();

	Bidder getBidderByNickname(String nickname);

	User getUserById(String id);

	int addUsers(List<? extends User> users);

	boolean addUser(User user);

	List<Bidder> getAllBidders();

	List<Gambler> getAllGamblers();

	List<Admin> getAllAdmins();
}
