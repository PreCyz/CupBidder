import bidder.model.Cup;
import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/** Created by gawa on 07.05.17. */
public class ModelMapper {

	private final String cupJson = "src/main/resources/sample/cup.json";

	public ModelMapper() { }

	public Cup cup() {
		Cup cup = null;
		try {
			File cupJsonFile = new File(cupJson);
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
			mapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
			cup = mapper.readValue(cupJsonFile, Cup.class);
			cup.getGames().forEach(game -> game.setId(generateId()));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			return cup;
		}
	}

	private String generateId() {
		int value;
		SecureRandom random;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			value = random.nextInt();
		} catch (NoSuchAlgorithmException e) {
			sun.security.provider.SecureRandom r = new sun.security.provider.SecureRandom();
			byte [] b = new byte[4];
			r.engineNextBytes(b);
			value = ((0xFF & b[0]) << 24) | ((0xFF & b[1]) << 16) |
					((0xFF & b[2]) << 8) | (0xFF & b[3]);
			System.out.println("Using a newly created SecureRandom object to generate tokens for captcha sessions: SHA1PRNG instance of SecureRandom was not found!");

		}
		value = Math.abs(value);
		return Integer.toString(value);
	}
}
