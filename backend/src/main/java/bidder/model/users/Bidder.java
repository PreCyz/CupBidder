package bidder.model.users;

import org.springframework.data.mongodb.core.mapping.Document;

/** Created by gawa on 01.05.17. */
@Document(collection = "users")
public class Bidder extends User {

	private String nickname;

	protected Bidder(UserType userType) {
		super(userType);
	}

	public Bidder() {
		this(UserType.Bidder);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
