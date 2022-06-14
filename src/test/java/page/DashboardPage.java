package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class DashboardPage extends BasePage{

    @FindBy(xpath = "//small[@class='muted'][contains(text(), 'Workouts')]/following-sibling::span")
    private WebElement amountOfWorkouts;

    public int getAmountOfWorkouts(){
        log.info("Get amount of created workouts");
        return Integer.parseInt(amountOfWorkouts.getText());
    }

}
