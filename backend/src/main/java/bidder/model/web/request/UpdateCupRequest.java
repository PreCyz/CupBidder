package bidder.model.web.request;

import javax.validation.constraints.NotNull;

/** Created by Gawa on 25/05/17.*/
public class UpdateCupRequest {

    @NotNull
    private String id;
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
