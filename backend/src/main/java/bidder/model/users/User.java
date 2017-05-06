package bidder.model.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by gawa on 01.05.17.
 */
@Document(collection = "users")
public class User {

	@Id
	protected String id;
	protected String firstName;
	protected String lastName;
	@Indexed(unique = true, collection = "user", name = "emailIndex")
	protected String email;
	protected UserType type;

	public User() {
		this.type = UserType.Watcher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
