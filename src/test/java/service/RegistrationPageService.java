package service;

import lombok.extern.log4j.Log4j2;
import model.UserData;
import page.RegistrationPage;
import page.UserProfilePage;
import static utils.StringConstant.REGISTRATION_URL;

@Log4j2
public class RegistrationPageService {

    private final RegistrationPage registrationPage = new RegistrationPage();

    public UserProfilePage register(UserData user){
        try{
            registrationPage.openPage(REGISTRATION_URL)
                    .fillInFirstName(user.getFirstName())
                    .fillInLastName(user.getLastName())
                    .chooseTimeZone(user.getTimeZone())
                    .fillInEmail(user.getEmail())
                    .fillInPassword(user.getPassword())
                    .fillInConfirmPassword(user.getConfirmPassword())
                    .clickCreateNewAccountButton();}
        catch (Exception exception){
            log.error("Successful registration failed");
        }
        return new UserProfilePage();

    }

}
