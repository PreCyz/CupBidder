package bidder.model.web.response;

import bidder.model.Bid;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Size;
import java.util.List;

/** Created by Gawa on 16/06/17.*/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BidResponse {

    @Size(min = 1)
    private List<Bid> bids;

    public BidResponse(List<Bid> bids) {
        this.bids = bids;
    }

    public List<Bid> getBids() {
        return bids;
    }
}
