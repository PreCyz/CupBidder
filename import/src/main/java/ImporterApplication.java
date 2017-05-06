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
		userRepository.deleteAll();
		System.out.printf("Adding new user.%n");
		userRepository.save(newUser());
		userRepository.save(newBidder());
		System.out.printf("Adding new bidder.%n");
		final List<User> all = userRepository.findAll();
		System.out.printf("%d users were loaded from DB.%n", all.size());
		final Bidder gawa = userRepository.findByNickname("Gawa");
		System.out.printf("Read %s of type %s from DB.%n", gawa.getNickname(), gawa.getType());
		System.out.println("Importer out.");
	}

	private Bidder newBidder() {
		Bidder bidder = new Bidder();
		bidder.setNickname("Gawa");
		bidder.setEmail("precpaw@op.pl");
		bidder.setFirstName("Bidder");
		bidder.setLastName("Bidder");
		return bidder;
	}

	private User newUser() {
		User user = new User();
		user.setEmail("user@op.pl");
		user.setFirstName("User");
		user.setLastName("UserLastname");
		return user;
	}
}
