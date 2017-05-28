package bidder.model.web.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

/** Created by Gawa on 28/05/17.*/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LoginRequest {

    @NotNull
    private String email;
    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
