package java.com.scaler.machinecoding.strategies.spotassignmentstrategy;

import java.com.scaler.machinecoding.models.Gate;
import java.com.scaler.machinecoding.models.ParkingLot;
import java.com.scaler.machinecoding.models.Spot;
import java.com.scaler.machinecoding.models.VehicleType;

public interface SpotAssignmentStrategy {

    Spot findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate);
}
