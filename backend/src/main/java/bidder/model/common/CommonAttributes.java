package bidder.model.common;

import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/** Created by gawa on 07.05.17. */
public class CommonAttributes {

	@Id
	private String id;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime creationDate;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime lastModificationDate;

	public CommonAttributes() {
		creationDate = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(LocalDateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
}
