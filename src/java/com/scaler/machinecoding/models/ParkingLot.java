package java.com.scaler.machinecoding.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> paekingFloorList;
    private List<Gate> gates;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<ParkingFloor> getPaekingFloorList() {
        return paekingFloorList;
    }

    public void setPaekingFloorList(List<ParkingFloor> paekingFloorList) {
        this.paekingFloorList = paekingFloorList;
    }
}
