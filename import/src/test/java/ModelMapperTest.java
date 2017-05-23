import bidder.model.Cup;
import org.junit.Test;

import static org.junit.Assert.*;

/** Created by gawa on 2017-05-08. */
public class ModelMapperTest {

	@Test
	public void cupJsonParser() {
		Cup cup = new ModelMapper().cup();
		assertNotNull(cup);
	}

}