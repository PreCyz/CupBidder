package bidder.model.user;

import org.springframework.data.mongodb.core.mapping.Document;

/** Created by gawa on 01.05.17. */
@Document(collection = "users")
public class Gambler extends Bidder {

	private Double moneyPayed;

	public Gambler() {
		super(UserType.Gambler);
	}

	public Double getMoneyPayed() {
		return moneyPayed;
	}

	public void setMoneyPayed(Double moneyPayed) {
		this.moneyPayed = moneyPayed;
	}
}
