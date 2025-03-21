package main.com.scaler.models;

import java.util.List;

public class Spot extends BaseModel{
    private int number;
    private List<VehicleType> supportedVehicleTypes;
    private SpotStatus spotStatus;
    private Vehicle vehicle;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
