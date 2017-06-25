package bidder.service.impl;

import bidder.model.user.*;
import bidder.repositorie.UserRepository;
import bidder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/** Created by gawa on 01.05.17. */
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void dropAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	@Cacheable(cacheNames = "allUsers")
	public List<User> getAllUsers() {
		return userRepository.findAll(new Sort(Sort.Direction.ASC, "lastName"));
	}

	@Override
	public Bidder getBidderByNickname(String nickname) {
		return userRepository.findByNickname(nickname);
	}

	@Override
	public User getUserById(String id) {
		return userRepository.findById(id);
	}

	@Override
	@CacheEvict(cacheNames = {"allUsers","allBidders","allGamblers","allAdmins"})
	public int addUsers(List<? extends User> users) {
		final List<User> excludedUsers = users.stream()
				.filter(user -> userRepository.findByEmail(user.getEmail()) != null)
				.collect(Collectors.toList());
		final List<User> usersToAdd = users.stream()
				.filter(user -> userRepository.findByEmail(user.getEmail()) == null)
				.collect(Collectors.toList());
		final List<User> saved = userRepository.save(usersToAdd);
		return excludedUsers.size() + (saved == null ? 0 : saved.size());
	}

	@Override
	@CacheEvict(cacheNames = {"allUsers","allBidders","allGamblers","allAdmins"})
	public boolean addUser(User user) {
		final User userExists = userRepository.findByEmail(user.getEmail());
		if (userExists != null) {
			return false;
		}
		final User savedUser = userRepository.save(user);
		return savedUser != null;
	}

	@Override
	@Cacheable(cacheNames = "allBidders")
	public List<Bidder> getAllBidders() {
		final List<? extends User> users = userRepository.findByType(UserType.Bidder.name());
		return users.stream().map(user -> (Bidder) user).collect(Collectors.toList());
	}

	@Override
	@Cacheable(cacheNames = "allGamblers")
	public List<Gambler> getAllGamblers() {
		final List<? extends User> users = userRepository.findByType(UserType.Gambler.name());
		return users.stream().map(user -> (Gambler) user).collect(Collectors.toList());
	}

	@Override
	@Cacheable(cacheNames = "allAdmins")
	public List<Admin> getAllAdmins() {
		final List<? extends User> users = userRepository.findByType(UserType.Admin.name());
		return users.stream().map(user -> (Admin) user).collect(Collectors.toList());
	}

	@Override
	public List<User> getAllWatchers() {
		final List<? extends User> users = userRepository.findByType(UserType.Watcher.name());
		return users.stream().map(user -> (User) user).collect(Collectors.toList());
	}

	@Override
	public User login(String email, String password) {
		User user = userRepository.findByEmail(email);
		return user;
	}

}
