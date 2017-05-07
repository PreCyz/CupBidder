import bidder.model.users.*;
import bidder.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "bidder")
public class ImporterApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ImporterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.printf("Start importer.%nDropping database.%n");
		loadDB();
		verify();
	}

	private void loadDB() {
		userRepository.deleteAll();
		System.out.printf("Adding users.%n");
		userRepository.save(newAdmin());
		userRepository.save(newUser());
		userRepository.save(newBidder());
		userRepository.save(newGambler());
	}

	private void verify() {
		final List<User> all = userRepository.findAll();
		System.out.printf("%d users were loaded from DB.%n", all.size());
		Bidder bidder = userRepository.findByNickname("bidDer");
		System.out.printf("Read %s of type %s from DB.%n", bidder.getNickname(), bidder.getType());

		verify(UserType.Bidder);
		verify(UserType.Gambler);
		verify(UserType.Admin);
		verify(UserType.Watcher);

		System.out.println("Importer out.");
	}

	private void verify(UserType userType) {
		List<? extends User> bidders = userRepository.findByType(userType.name());
		System.out.printf("There are %d %s in DB.%n", bidders.size(), userType.name());
		for (User user : bidders) {
			switch (userType) {
				case Watcher:
					System.out.printf("Read %s of type %s from DB.%n", user.getFirstName(), user.getType());
					break;
				case Admin:
					Admin admin = (Admin) user;
					System.out.printf("Read %s of type %s from DB.%n", admin.getFirstName(), admin.getType());
					break;
				case Bidder:
					Bidder bidder = (Bidder) user;
					System.out.printf("Read %s of type %s from DB.%n", bidder.getNickname(), bidder.getType());
					break;
				case Gambler:
					Gambler gambler = (Gambler) user;
					System.out.printf("Read %s of type %s from DB.%n", gambler.getNickname(), gambler.getType());
					break;
			}
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
		user.setEmail("user@cup.com");
		user.setFirstName("User");
		user.setLastName("User");
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
