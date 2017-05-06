package bidder.model.users;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by gawa on 01.05.17.
 */
@Document(collection = "user")
public class Bidder extends User {

	@Size(min = 0)
	protected List<Bid> bids;
	protected String nickname;

	public Bidder() {
		this.type = UserType.Bidder;
	}

	public void addBid(Bid bid) {
		bids.add(bid);
	}

	public List<Bid> getBids() {
		if (bids == null) {
			bids = new LinkedList<>();
		}
		return bids;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public UserType getType() {
		return type;
	}
}
