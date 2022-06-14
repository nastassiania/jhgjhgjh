package elements;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {

    private static final String TIME_OF_DAY_XPATH = "//ul[@class='ui-timepicker-list picktime']//li[contains(text(),'%s')]";
    private static final String PERCEIVED_EFFORT_XPATH = "//option[contains(text(), '%s')]";
    private static final String TOP_MENU_OPTION_XPATH = "//ul[@id='mobile-nav']//a[contains(text(), '%s')]";
    private static final String EQUIPMENT_TO_CHOOSE_XPATH = "//ul[@class='select2-results']//div[contains(text(), '%s')]";

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();
    private final String label;

    public DropDown(String label) {
        this.label = label;
    }

    public void chooseTimeOfDay() {
        driver.findElement(By.xpath(String.format(TIME_OF_DAY_XPATH, label))).click();
    }

    public void choosePerceivedEffort() {
        driver.findElement(By.xpath(String.format(PERCEIVED_EFFORT_XPATH, label))).click();
    }

    public void chooseTopMenuOption() {
        driver.findElement(By.xpath(String.format(TOP_MENU_OPTION_XPATH, label))).click();
    }

    public void chooseEquipmentBrand() {
        driver.findElement(By.xpath(String.format(EQUIPMENT_TO_CHOOSE_XPATH, label))).click();
    }

}
