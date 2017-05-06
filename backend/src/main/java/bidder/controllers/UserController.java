package bidder.controllers;

import bidder.model.users.User;
import bidder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by gawa on 01.05.17.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/all", method = GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(path = "/{nickname}", method = GET)
	public User getUserByNickName(@PathVariable("nickname") String nickname) {
		return userService.getBidderByNickname(nickname);
	}
}
