package service;

import lombok.extern.log4j.Log4j2;
import page.LogoutPage;
import page.TopBarPage;

@Log4j2
public class TopBarPageService {

    private TopBarPage topBarPage = new TopBarPage();

    public LogoutPage logOut() {
        try {
            topBarPage.clickLogOutButton();
        } catch (Exception exception) {
            log.error("Logout failed!");
        }
        return new LogoutPage();
    }

}
