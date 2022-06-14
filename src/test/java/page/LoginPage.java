package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='login_name']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class ='alert alert-success']//strong")
    private WebElement messageAfterSuccessfulLogOut;

    @FindBy(xpath = "//div[@class ='alert alert-error']//strong")
    private WebElement errorMessage;

    @Step("Open {url}")
    public LoginPage openPage(String url) {
        log.info("Open login page");
        driver.get(url);
        return this;
    }

    @Step("Input {emailToEnter} into the email field")
    public LoginPage fillInEmail(String emailToEnter) {
        log.info("Enter email");
        email.clear();
        email.sendKeys(emailToEnter);
        return this;
    }

    @Step("Input {passwordToEnter} into the password field")
    public LoginPage fillInPassword(String passwordToEnter) {
        log.info("Enter password");
        password.clear();
        password.sendKeys(passwordToEnter);
        return this;
    }

    @Step("Click 'Login'")
    public void clickLoginButton() {
        log.info("Click \"Login\" button");
        loginButton.click();
    }

    public String getTextOfErrorMessage() {
        log.info("Get text of error message");
        return errorMessage.getText();
    }


}
