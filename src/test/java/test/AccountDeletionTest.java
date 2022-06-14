package test;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import model.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import page.LogoutPage;
import page.TopBarPage;
import service.LoginPageService;
import service.RegistrationPageService;
import service.UserProfilePageService;
import static utils.MailGenerator.getTemporaryEmail;
import static utils.StringConstant.*;

@Log4j2
public class AccountDeletionTest extends BaseTest {

    private UserProfilePageService userProfilePageService;
    private LogoutPage logoutPage;
    private LoginPageService loginPageService;
    private String tempEmail;


    @BeforeClass
    public void login() {
        userProfilePageService = new UserProfilePageService();
        logoutPage = new LogoutPage();
        RegistrationPageService registrationPageService = new RegistrationPageService();
        loginPageService = new LoginPageService();
        tempEmail = getTemporaryEmail();
        UserData user = UserData.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(tempEmail)
                .timeZone(timeZone)
                .password(password)
                .confirmPassword(password)
                .build();
        registrationPageService.register(user);
        new TopBarPage().clickSettingsButton();
    }

    @Test(description = "Deletion of created account")
    @Description("Deletion of created account")
    public void deleteAccountTest() {
        logoutPage = userProfilePageService.deleteAccount();
        String actualMessageAfterAccountDeletion = logoutPage.getTextOfMessageAfterSuccessfulLogOut();
        String expectedMessageAfterAccountDeletion = successful_logout;
        Assert.assertEquals(actualMessageAfterAccountDeletion, expectedMessageAfterAccountDeletion, "Actual message doesn't match the expected one!");
    }

    @Test(dependsOnMethods = "deleteAccountTest", description = "Verification that user can't login with credentials of previously deleted account")
    @Description("Verification that user can't login with credentials of previously deleted account")
    public void verifyAccountWasDeletedTest() {
        logoutPage.clickAccountLoginButton();
        loginPageService.logIn(UserData.builder().email(tempEmail).password(password).build());
        LoginPage loginPage = new LoginPage();
        String actualLoginMessage = loginPage.getTextOfErrorMessage();
        String expectedLoginMessage = invalid_login_creds;
        Assert.assertEquals(actualLoginMessage, expectedLoginMessage, "Actual message doesn't match the expected one!");
    }

}
