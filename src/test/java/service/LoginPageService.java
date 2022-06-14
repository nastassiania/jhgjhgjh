package service;

import lombok.extern.log4j.Log4j2;
import model.UserData;
import page.LoginPage;
import static utils.StringConstant.LOGIN_URL;

@Log4j2
public class LoginPageService {

    private final LoginPage loginPage = new LoginPage();

    public void logIn(UserData credentials){
        try{
            loginPage.openPage(LOGIN_URL)
                    .fillInEmail(credentials.getEmail())
                    .fillInPassword(credentials.getPassword())
                    .clickLoginButton();}
        catch (Exception exception){
            log.error("Successful login failed!");
        }
    }

}
