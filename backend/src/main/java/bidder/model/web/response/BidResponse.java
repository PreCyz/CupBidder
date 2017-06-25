package bidder.model.web.response;

import bidder.model.Bid;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Size;
import java.util.Set;

/** Created by Gawa on 16/06/17.*/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BidResponse {

    @Size(min = 1)
    private Set<Bid> bids;

    public BidResponse(Set<Bid> bids) {
        this.bids = bids;
    }

    public Set<Bid> getBids() {
        return bids;
    }
}
