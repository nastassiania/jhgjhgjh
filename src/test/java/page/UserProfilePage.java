package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiter.waitElementToBeClickable;

@Log4j2
public class UserProfilePage extends BasePage {

    @FindBy(xpath = "//span[@class='dropdown-toggle'][contains(.,'Edit Profile')]")
    private WebElement editProfileButton;

    @FindBy(xpath = "//a[@id='del-user']")
    private WebElement deleteAccountAndAllThePersonalDataButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement acceptAccountDeletionOKButton;

    @FindBy(xpath = "//ul[@id='breadcrumbs']//span")
    private WebElement messageWhenLoggedIn;

    @Step("Click \"Edit Profile\" button")
    public UserProfilePage clickEditProfileButton() {
        log.info("Click \"Edit Profile\" button");
        editProfileButton.click();
        return this;
    }

    @Step("Click \"Delete Account And All The Personal Data\"")
    public UserProfilePage clickDeleteAccountAndAllThePersonalDataButton() {
        log.info("Click \"Delete Account And All The Personal Data\"");
        deleteAccountAndAllThePersonalDataButton.click();
        return this;
    }

    @Step("Click \"Ok\" button when accepting account deletion")
    public void acceptAccountDeletion() {
        log.info("Click \"Ok\" button when accepting account deletion");
        waitElementToBeClickable(acceptAccountDeletionOKButton);
        acceptAccountDeletionOKButton.click();
    }

    public String getTextOfMessageWhenLoggedIn() {
        log.info("Get text on training calendar page top");
        return messageWhenLoggedIn.getText();
    }

}
