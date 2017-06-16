package bidder.model.match;

import bidder.model.common.CommonAttributes;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/** Created by Gawa on 06.05.17. */
@Document(collection = "games")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Game extends CommonAttributes {

	private String cupId;
	private String homeTeamName;
	private String awayTeamName;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime startDateTime;

	public Game() {}

	public Game(String cupId, String homeTeamName, String awayTeamName, LocalDateTime startDateTime) {
		this.cupId = cupId;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.startDateTime = startDateTime;
	}

	public String getCupId() {
		return cupId;
	}

	public void setCupId(String cupId) {
		this.cupId = cupId;
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
