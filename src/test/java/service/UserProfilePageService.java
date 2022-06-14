package service;

import lombok.extern.log4j.Log4j2;
import page.*;

@Log4j2
public class UserProfilePageService {

    private final UserProfilePage userProfilePage = new UserProfilePage();

    public LogoutPage deleteAccount() {
        try {
            userProfilePage.clickEditProfileButton()
                    .clickDeleteAccountAndAllThePersonalDataButton()
                    .acceptAccountDeletion();
        } catch (Exception exception) {
            log.error("Account deletion failed");
        }
        return new LogoutPage();

    }


}
