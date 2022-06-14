package test;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import model.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LogoutPage;
import page.TopBarPage;
import page.UserProfilePage;
import service.LoginPageService;
import utils.Retry;

import static utils.StringConstant.*;

@Log4j2
public class LoginAndLogoutSuccessfullyTest extends BaseTest {

    private LoginPageService loginPageService;
    private TopBarPage topBarPage;
    private UserProfilePage userProfilePage;
    private LogoutPage logoutPage;

    @BeforeTest
    public void loginLogout() {
        loginPageService = new LoginPageService();
        topBarPage = new TopBarPage();
        userProfilePage = new UserProfilePage();
        logoutPage = new LogoutPage();
    }

    @Test(description = "Successful login", retryAnalyzer = Retry.class)
    @Description("Successful login")
    public void logInSuccessfullyTest() {
        UserData credentials = UserData.builder()
                .email(email)
                .password(password)
                .build();
        loginPageService.logIn(credentials);
        String actualLogInMessage = userProfilePage.getTextOfMessageWhenLoggedIn();
        String expectedLogInMessage = successful_login;
        Assert.assertEquals(actualLogInMessage, expectedLogInMessage, "Actual message doesn't match the expected one!");
    }

    @Test(dependsOnMethods = "logInSuccessfullyTest", description = "Successful logout")
    public void logOutTest() {
        topBarPage.clickLogOutButton();
        String actualLogOutMessage = logoutPage.getTextOfMessageAfterSuccessfulLogOut();
        String expectedLogOutMessage = successful_logout;
        Assert.assertEquals(actualLogOutMessage, expectedLogOutMessage, "Actual message doesn't match the expected one!");
    }

}
