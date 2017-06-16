package bidder.model;

import bidder.model.common.CommonAttributes;
import bidder.model.match.Score;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/** Created by gawa on 01.05.17.*/
@Document(collection = "bids")
public class Bid extends CommonAttributes {

	@NotNull
	private String cupId;
	@NotNull
	private String userId;
	@NotNull
	private Score score;

	public Bid() {
		super();
	}

	public String getCupId() {
		return cupId;
	}

	public void setCupId(String cupId) {
		this.cupId = cupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
