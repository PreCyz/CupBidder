package bidder.model.users;

import bidder.model.CommonAttributes;
import org.springframework.data.mongodb.core.mapping.Document;

/** Created by gawa on 01.05.17. */
@Document(collection = "users")
public class User extends CommonAttributes {

	private String firstName;
	private String lastName;
	//@Indexed(unique = true, collection = "user", name = "emailIndex")
	private String email;
	private UserType type;

	public User() {
		super();
		this.type = UserType.Watcher;
	}

	protected User(UserType userType) {
		this.type = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserType getType() {
		return type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
