package bidder.model;

import bidder.model.match.Score;
import bidder.model.users.Bidder;
import org.springframework.data.mongodb.core.mapping.Document;

/** Created by gawa on 01.05.17.*/
@Document(collection = "bids")
public class Bid extends CommonFields {

	private Bidder bidder;
	private Score score;

	public Bid() {
		super();
	}

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
