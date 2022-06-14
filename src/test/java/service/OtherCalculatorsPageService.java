package service;

import lombok.extern.log4j.Log4j2;
import model.CalculatorData;
import page.*;

@Log4j2
public class OtherCalculatorsPageService {

    private final TopBarPage topBarPage = new TopBarPage();
    private final OtherCalculatorPage otherCalculatorPage = new OtherCalculatorPage();
    private final CalculatorData calculatorData = new CalculatorData();

    public OtherCalculatorPage checkCaloricNeeds() {
        try {
            topBarPage.openOtherCalculatorsLogoButton();
            otherCalculatorPage.fillInWeight(calculatorData.getWeightToEnter())
                    .chooseWeightTypeKilos()
                    .fillInHeight(calculatorData.getHeightToEnter())
                    .chooseHeightTypeCentimeters()
                    .fillInAge(calculatorData.getAgeToEnter())
                    .chooseMaleGender()
                    .fillInTodayRunDistance(calculatorData.getTodayRunDistanceToEnter())
                    .chooseDistanceTypeKm()
                    .clickCalculateCaloricNeedsButton();
        } catch (Exception exception) {
            log.error("Checking caloric needs failed!");
        }
        return new OtherCalculatorPage();

    }
}
