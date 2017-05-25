package bidder.model.web.response;

import bidder.model.Cup;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Size;
import java.util.List;

/** Created by gawa on 25/05/17.*/
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CupResponse {

    @Size(min = 1)
    private List<Cup> cups;

    public CupResponse(List<Cup> cups) {
        this.cups = cups;
    }

    public List<Cup> getCups() {
        return cups;
    }
}
