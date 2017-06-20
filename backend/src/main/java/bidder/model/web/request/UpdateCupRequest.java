package bidder.model.web.request;

import javax.validation.constraints.NotNull;

/** Created by Gawa on 25/05/17.*/
public class UpdateCupRequest {

    @NotNull
    private String cupId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCupId() {
        return cupId;
    }

    public void setCupId(String cupId) {
        this.cupId = cupId;
    }

}
