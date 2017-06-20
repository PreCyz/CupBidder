package bidder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.mapping.Document;

/** Created by gawa on 01.05.17.*/
@Document(collection = "bids")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Bid extends Score {

}
