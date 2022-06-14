package test;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import model.UserData;
import org.testng.Assert;
import org.testng.annotations.*;
import page.OtherCalculatorPage;
import service.LoginPageService;
import service.OtherCalculatorsPageService;

import static utils.StringConstant.*;

@Log4j2
public class OtherCalculatorTest extends BaseTest{

        private OtherCalculatorPage otherCalculatorPage;
        private OtherCalculatorsPageService otherCalculatorsPageService;

        @BeforeClass
        public void logIn() {
            otherCalculatorPage = new OtherCalculatorPage();
            otherCalculatorsPageService = new OtherCalculatorsPageService();
            LoginPageService loginPageService = new LoginPageService();
            loginPageService.logIn(UserData.builder().email(email).password(password).build());
        }

        @Test(description = "Verification that CaloriesNeeds Calculator counts properly")
        @Description("Verification that CaloriesNeeds Calculator counts properly")
        public void checkCaloriesNeedsCalculatorTest() {
            otherCalculatorPage = otherCalculatorsPageService.checkCaloricNeeds();
            String actualCaloriesForTestPerson = otherCalculatorPage.getTextOfTodayCaloricNeeds();
            String expectedCaloriesForTestPerson = caloricNeed;
            Assert.assertTrue(actualCaloriesForTestPerson.contains(expectedCaloriesForTestPerson), "Actual amount of calories doesn't match the expected one!");

        }

    }
