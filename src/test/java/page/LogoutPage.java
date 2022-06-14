package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LogoutPage extends BasePage{

    @FindBy(xpath = "//div[@class ='alert alert-success']//strong")
    private WebElement messageAfterSuccessfulLogOut;

    @FindBy(xpath = "//a[contains(text(), 'Account Login')]")
    private WebElement accountLoginButton;

    public String getTextOfMessageAfterSuccessfulLogOut(){
        log.info("Get text of message after successful logout");
        return messageAfterSuccessfulLogOut.getText();
    }

    @Step("Click Account Login button")
    public void clickAccountLoginButton(){
        log.info("Click \"Account Login\" button");
        accountLoginButton.click();
    }


}
