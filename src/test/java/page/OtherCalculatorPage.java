package page;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class OtherCalculatorPage extends BasePage{

    @FindBy(xpath = "//input[@class='span2 inline'][@id='Weight']")
    private WebElement weight;

    @FindBy(xpath = "//input[@name='WeightType'][@id='optionsRadios4']")
    private WebElement weightTypeKilos;

    @FindBy(xpath = "//input[@class='span2 inline'][@id='HeightInchCent']")
    private WebElement height;

    @FindBy(xpath = "//input[@name='HeightType'][@id='optionsRadios4']")
    private WebElement heightTypeCentimeters;

    @FindBy(xpath = "//input[@class='span4 inline'][@id='Age']")
    private WebElement age;

    @FindBy(xpath = "//input[@name='Gender'][@id='optionsRadios5']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@class='span2 inline'][@id='RunDist']")
    private WebElement todayRunDistance;

    @FindBy(xpath = "//input[@name='DistType'][@id='optionsRadios8']")
    private WebElement distanceTypeKm;

    @FindBy(xpath = "//input[@id='saveButtonSettings']")
    private WebElement calculateCaloricNeedsButton;

    @FindBy(xpath = "//div[@class='span6']//div[@class='w-box w-box-green']//tbody//tr")
    private WebElement todayCaloricNeeds;

    @Step("Input {weightToEnter} into the weight field")
    public OtherCalculatorPage fillInWeight(String weightToEnter){
        log.info("Enter weight");
        weight.sendKeys(weightToEnter);
        return this;
    }

    @Step("Choose type of weight - kilos")
    public OtherCalculatorPage chooseWeightTypeKilos(){
        log.info("Choose type of weight - kilos");
        weightTypeKilos.click();
        return this;
    }

    @Step("Input {heightToEnter} into the height field")
    public OtherCalculatorPage fillInHeight(String heightToEnter){
        log.info("Enter height");
        height.sendKeys(heightToEnter);
        return this;
    }

    @Step("Choose height type - cm")
    public OtherCalculatorPage chooseHeightTypeCentimeters(){
        log.info("Choose height type - cm");
        heightTypeCentimeters.click();
        return this;
    }

    @Step("Input {ageToEnter} into the age field")
    public OtherCalculatorPage fillInAge(String ageToEnter){
        log.info("Enter age");
        age.sendKeys(ageToEnter);
        return this;
    }

    @Step("Choose gender - male")
    public OtherCalculatorPage chooseMaleGender(){
        log.info("Choose gender - male");
        genderMale.click();
        return this;
    }

    @Step("Input {todayRunDistanceToEnter} into the Today Run Distance field")
    public OtherCalculatorPage fillInTodayRunDistance(String todayRunDistanceToEnter){
        log.info("Enter today run distance");
        todayRunDistance.sendKeys(todayRunDistanceToEnter);
        return this;
    }

    @Step("Choose distance type - km")
    public OtherCalculatorPage chooseDistanceTypeKm(){
        log.info("Choose distance type - km");
        distanceTypeKm.click();
        return this;
    }

    @Step("Click \"Calculate caloric needs\" button")
    public void clickCalculateCaloricNeedsButton(){
        log.info("Click \"Calculate caloric needs\" button");
        calculateCaloricNeedsButton.click();
    }

    public String getTextOfTodayCaloricNeeds(){
        log.info("Get text of \"Today caloric needs\" field");
        return todayCaloricNeeds.getText();
    }

}
