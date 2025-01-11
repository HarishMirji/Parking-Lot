package java.com.scaler.machinecoding.models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<Spot> spots;
    private int floorNumber;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }
}
