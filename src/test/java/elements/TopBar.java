package elements;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopBar {

    private static final String TOP_MENU_XPATH = "//a[@class='arrow_down'][contains(text(), '%s')]";

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    private final String label;

    public TopBar(String label) {
        this.label = label;
    }

    public void chooseTopMenuOption(){
        Actions action = new Actions(driver);
        WebElement elementToHoverTo = driver.findElement(By.xpath(String.format(TOP_MENU_XPATH, label)));
        action.moveToElement(elementToHoverTo).perform();
    }
}
