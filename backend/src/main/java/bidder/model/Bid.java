package bidder.model;

import bidder.model.common.CommonAttributes;
import bidder.model.match.Score;
import org.springframework.data.mongodb.core.mapping.Document;

/** Created by gawa on 01.05.17.*/
@Document(collection = "bids")
public class Bid extends CommonAttributes {

	private String bidderId;
	private Score score;

	public Bid() {
		super();
	}

	public String getBidderId() {
		return bidderId;
	}

	public void setBidderId(String bidderId) {
		this.bidderId = bidderId;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
