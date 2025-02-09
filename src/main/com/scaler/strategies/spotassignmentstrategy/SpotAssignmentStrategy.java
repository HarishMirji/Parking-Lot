package main.com.scaler.strategies.spotassignmentstrategy;

import main.com.scaler.models.Gate;
import main.com.scaler.models.ParkingLot;
import main.com.scaler.models.Spot;
import main.com.scaler.models.VehicleType;
import java.util.Optional;

public interface SpotAssignmentStrategy {

    Optional<Spot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate);
}
