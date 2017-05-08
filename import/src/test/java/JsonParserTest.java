import bidder.model.Cup;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gawa on 2017-05-07.
 */
public class JsonParserTest {

	@Test
	public void cupJsonParser() {
		Cup cup = new JsonParser().cup();
		assertNotNull(cup);
	}

}