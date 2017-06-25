package bidder.model.user;

import org.springframework.data.mongodb.core.mapping.Document;

/** Created by gawa on 01.05.17. */
@Document(collection = "users")
public class Admin extends User {

	public Admin() {
		super(UserType.Admin);
	}
}
