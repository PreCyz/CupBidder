package bidder.model.users;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by gawa on 01.05.17.
 */
@Document(collection = "users")
public class Admin extends User {

	public Admin() {
		this.type = UserType.Admin;
	}
}
