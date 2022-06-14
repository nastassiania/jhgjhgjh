package test;

import driver.DriverSingleton;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        log.info("Get Driver");
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
        log.info("Stop Browser");
        DriverSingleton.getInstance().closeDriver();
    }

}
