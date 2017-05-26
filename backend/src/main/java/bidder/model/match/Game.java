package bidder.model.match;

import bidder.model.common.CommonAttributes;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/** Created by Gawa on 06.05.17. */
@Document(collection = "games")
public class Game extends CommonAttributes {

	private String homeTeamName;
	private String awayTeamName;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime startDateTime;

	public Game() {}

	public Game(String homeTeamName, String awayTeamName, LocalDateTime startDateTime) {
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.startDateTime = startDateTime;
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public String getAwayTeamName() {
		return awayTeamName;
	}

	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

}
