package bidder.service;

import bidder.model.user.Admin;
import bidder.model.user.Bidder;
import bidder.model.user.Gambler;
import bidder.model.user.User;

import java.util.List;

/** Created by gawa on 01.05.17. */
public interface UserService {
	void dropAllUsers();
	List<User> getAllUsers();
	Bidder getBidderByNickname(String nickname);
	User getUserById(String id);
	int addUsers(List<? extends User> users);
	boolean addUser(User user);
	List<Bidder> getAllBidders();
	List<Gambler> getAllGamblers();
	List<Admin> getAllAdmins();
	List<User> getAllWatchers();
	User login(String email, String password);
}
