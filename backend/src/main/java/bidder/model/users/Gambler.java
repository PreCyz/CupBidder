package bidder.model.users;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by gawa on 01.05.17.
 */
@Document(collection = "users")
public class Gambler extends Bidder {

	protected Double moneyPayed;

	public Gambler() {
		type = UserType.Gambler;
	}

	public Double getMoneyPayed() {
		return moneyPayed;
	}

	public void setMoneyPayed(Double moneyPayed) {
		this.moneyPayed = moneyPayed;
	}
}
