import bidder.generator.IdGenerator;
import bidder.model.Cup;
import bidder.model.CupStatus;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

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
			cup.setStatus(CupStatus.New);
			cup.getGames().forEach(game -> game.setId(IdGenerator.generateId()));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			return cup;
		}
	}
}
