package service;

import lombok.extern.log4j.Log4j2;
import model.EquipmentData;
import page.EquipmentPage;

@Log4j2
public class EquipmentPageService {

    private final EquipmentPage equipmentPage = new EquipmentPage();
    private final EquipmentData equipmentData = new EquipmentData();

    public EquipmentPage addNewEquipment() {
        try {
            equipmentPage.fillInEquipmentName(equipmentData.getBikeName())
                    .chooseEquipmentBrand(equipmentData.getBikeBrand())
                    .fillInEquipmentModel(equipmentData.getBikeModel())
                    .fillInEquipmentCost(equipmentData.getBikeCost())
                    .chooseDateOfPurchase()
                    .fillInStartingDistance(equipmentData.getBikeStartingDistance())
                    .chooseDistanceType(equipmentData.getDistanceType())
                    .clickAddEquipmentButton();
        } catch (Exception exception) {
            log.error("New equipment addition failed!");
        }
        return new EquipmentPage();
    }


}
