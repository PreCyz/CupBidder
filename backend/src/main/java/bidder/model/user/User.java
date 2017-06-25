package bidder.model.user;

import bidder.model.common.CommonAttributes;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.mapping.Document;

/** Created by gawa on 01.05.17. */
@Document(collection = "users")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User extends CommonAttributes implements Comparable<User> {

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

	@Override
	public int compareTo(User o) {
		if (firstName.compareTo(o.getFirstName()) != 0) {
			return firstName.compareTo(o.getFirstName());
		}
		if (lastName.compareTo(o.getLastName()) != 0) {
			return lastName.compareTo(o.getLastName());
		}
		if (email.compareTo(o.getEmail()) != 0) {
			return email.compareTo(o.getEmail());
		}
		return type.compareTo(o.getType());
	}
}
