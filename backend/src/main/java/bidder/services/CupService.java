package bidder.services;

import bidder.model.Cup;

/** Created by gawa on 06.05.17. */
public interface CupService {

	void dropCups();

	Cup addCup(Cup cup);
}
