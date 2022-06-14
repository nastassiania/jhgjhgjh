package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserData {

    private String firstName;
    private String lastName;
    private String email;
    private String timeZone;
    private String password;
    private String confirmPassword;
    private String wrongConfirmPassword;

}
