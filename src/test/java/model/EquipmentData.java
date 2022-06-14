package model;

import lombok.Getter;

@Getter
public class EquipmentData {

    private String bikeName = "My bike";
    private String bikeBrand = "Giant";
    private String bikeModel = "Classic";
    private int bikeCost = 1000;
    private double bikeStartingDistance = 12.66;
    private String distanceType = "km";

    public EquipmentData() {
    }
}
