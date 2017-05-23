import bidder.model.Cup;
import bidder.model.match.Game;
import bidder.model.users.*;
import bidder.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.*;

@SpringBootApplication
@ComponentScan(basePackages = "bidder")
public class ImporterApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private GameService gameService;

	@Autowired
	private CupService cupService;

	public static void main(String[] args) {
		SpringApplication.run(ImporterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.printf("Start importer.%nDropping database.%n");
		loadUsers();
		loadCup();
		verify();
	}

	private void loadCup() {
		System.out.println("Dropping cup.");
		cupService.dropCups();
		System.out.println("Dropping games.");
		gameService.dropGames();

		ModelMapper modelMapper = new ModelMapper();
		Cup cup = modelMapper.cup();
		System.out.println("Loading games.");
		List<Game> loadedGames = gameService.addAllGames(cup.getGames());
		cup.setGames(loadedGames);
		System.out.println("Loading cup.");
		cupService.addCup(cup);
	}

	private void loadUsers() {
		System.out.println("Dropping users.");
		userService.dropAllUsers();
		System.out.printf("Adding users.%n");
		userService.addUsers(Arrays.asList(newAdmin(), newUser(), newBidder(), newGambler()));
	}

	private void verify() {
		final List<User> all = userService.getAllUsers();
		System.out.printf("%d users were loaded from DB.%n", all.size());
		Bidder bidder = userService.getBidderByNickname("bidDer");
		System.out.printf("Read %s of type %s from DB.%n", bidder.getNickname(), bidder.getType());

		verify(UserType.Bidder);
		verify(UserType.Gambler);
		verify(UserType.Admin);
		verify(UserType.Watcher);

		System.out.println("Importer out.");
	}

	private void verify(UserType userType) {
		switch (userType) {
			case Watcher:
				displayList(userType, userService.getAllWatchers());
				break;
			case Admin:
				displayList(userType,  userService.getAllAdmins());
				break;
			case Bidder:
				displayList(userType, userService.getAllBidders());
				break;
			case Gambler:
				displayList(userType, userService.getAllGamblers());
				break;
		}
	}

	private <T extends User> void displayList(UserType userType, List<T> list) {
		System.out.printf("There are %d %s in DB.%n", list.size(), userType.name());
		for (User user : list) {
			System.out.printf("Read %s of type %s from DB.%n", user.getFirstName(), user.getType());
		}
	}

	private User newAdmin() {
		User admin = new Admin();
		admin.setEmail("admin@cup.com");
		admin.setFirstName("Admin");
		admin.setLastName("Admin");
		return admin;
	}

	private User newUser() {
		User user = new User();
		user.setEmail("watcher@cup.com");
		user.setFirstName("watcher");
		user.setLastName("watcher");
		return user;
	}

	private User newBidder() {
		Bidder bidder = new Bidder();
		bidder.setNickname("bidDer");
		bidder.setEmail("bidder@cup.com");
		bidder.setFirstName("Bidder");
		bidder.setLastName("Bidder");
		return bidder;
	}

	private User newGambler() {
		Gambler gambler = new Gambler();
		gambler.setFirstName("Gambler");
		gambler.setLastName("Gambler");
		gambler.setEmail("gambler@cup.com");
		gambler.setNickname("gamBler");
		return gambler;
	}
}
