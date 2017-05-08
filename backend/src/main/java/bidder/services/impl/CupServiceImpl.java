package bidder.services.impl;

import bidder.model.Cup;
import bidder.repositories.CupRepository;
import bidder.services.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Created by gawa on 2017-05-08. */
@Service
public class CupServiceImpl implements CupService {

	@Autowired
	private CupRepository cupRepository;

	@Override
	public void dropCups() {
		cupRepository.deleteAll();
	}

	@Override
	public Cup addCup(Cup cup) {
		return cupRepository.save(cup);
	}
}
