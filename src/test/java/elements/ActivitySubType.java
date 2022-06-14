package elements;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utils.Waiter.waitVisibilityOfElementLocated;

public class ActivitySubType {

    private static final String ACTIVITY_SUB_TYPE_XPATH = "//li[@class='subtypeselector']//a[contains(text(),'%s')]";

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    private final String label;

    public ActivitySubType(String label) {
        this.label = label;
    }

    public void chooseActivitySubType() {
        waitVisibilityOfElementLocated(ACTIVITY_SUB_TYPE_XPATH, label);
        driver.findElement(By.xpath(String.format(ACTIVITY_SUB_TYPE_XPATH, label))).click();
    }


}
