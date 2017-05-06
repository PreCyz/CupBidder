package bidder.model.users;

import bidder.model.Bid;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.*;

/**
 * Created by gawa on 01.05.17.
 */
@Document(collection = "users")
public class Bidder extends User {

	protected String nickname;

	public Bidder() {
		this.type = UserType.Bidder;
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
