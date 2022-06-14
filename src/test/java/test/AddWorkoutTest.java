package test;


import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import model.UserData;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.TopBarPage;
import service.AddWorkoutPageService;
import service.LoginPageService;
import static utils.StringConstant.*;

@Log4j2
public class AddWorkoutTest extends BaseTest {

    private DashboardPage dashboardPage;
    private TopBarPage topBarPage;
    private AddWorkoutPageService addWorkoutPageService;

    @BeforeClass
    public void doBeforeClass() {
        dashboardPage = new DashboardPage();
        topBarPage = new TopBarPage();
        addWorkoutPageService = new AddWorkoutPageService();
        LoginPageService loginPageService = new LoginPageService();
        loginPageService.logIn(UserData.builder().email(email).password(password).build());
    }

    @Test(description = "New Long Run activity addition")
    @Description("New Long Run activity addition")
    public void addWorkoutRunLongRunTest() {
        topBarPage.clickDashboardLogoButton();
        int amountOfWorkoutsStart = getQuantityOfWorkouts();
        System.out.println(amountOfWorkoutsStart);
        topBarPage.chooseNeededOptionInUpperBar(workouts, addWorkout);
        addWorkoutPageService.addNewRunWorkout(longRun);
        topBarPage.clickDashboardLogoButton();
        int amountOfWorkoutsAfterAddingNewWorkout = getQuantityOfWorkouts();
        System.out.println(amountOfWorkoutsAfterAddingNewWorkout);
        Assert.assertEquals(amountOfWorkoutsAfterAddingNewWorkout,(amountOfWorkoutsStart), "New workout was not added!");

    }

    @AfterTest
    public void doAfterTest(){
        topBarPage.clickLogOutButton();
    }

    private int getQuantityOfWorkouts() {
        try {
            return dashboardPage.getAmountOfWorkouts();
        } catch (NoSuchElementException Ex) {
            return 0;
        }
    }

}
