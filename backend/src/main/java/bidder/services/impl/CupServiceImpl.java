package bidder.services.impl;

import bidder.model.Cup;
import bidder.model.web.response.CupResponse;
import bidder.repositories.CupRepository;
import bidder.services.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public List<Cup> getCups() {
		return cupRepository.findAll();
	}
}
