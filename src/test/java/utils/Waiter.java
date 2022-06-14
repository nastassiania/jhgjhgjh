package utils;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public Waiter() {
    }

    protected static WebDriver driver = DriverSingleton.getInstance().getDriver();

    private static final int durationSec = 10;

    public static void waitElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.elementToBeClickable(element));}

    public static void waitVisibilityOf(WebElement element){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.visibilityOf(element));}

    public static void waitVisibilityOfElementLocated(String xPath, String label){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(xPath, label))));}

}
