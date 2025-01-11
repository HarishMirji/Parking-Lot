package java.com.scaler.machinecoding.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private Spot parkingSpot;
    private Date entryTime;
    private Vehicle vehicle;
    private Gate gate;
    private Operator operator;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Spot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(Spot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
