package bidder.controller;

import bidder.model.user.User;
import bidder.model.web.request.LoginRequest;
import bidder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/** Created by Gawa on 01.05.17. */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(path = "/login")
	public User login(@Valid @RequestBody LoginRequest loginRequest) {
		return userService.login(loginRequest.getEmail(), loginRequest.getPassword());
	}

	@GetMapping(path = "")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "/{nickname}")
	public User getUserByNickName(@PathVariable("nickname") String nickname) {
		return userService.getBidderByNickname(nickname);
	}
}
