package main.com.scaler.strategies.spotassignmentstrategy;

import main.com.scaler.models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public Optional<Spot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloorList()) {
            for (Spot spot : parkingFloor.getSpots()) {
                if (spot.getSpotStatus().equals(SpotStatus.AVAILABLE) &&
                        spot.getSupportedVehicleTypes().contains(vehicleType)) {
                    return Optional.of(spot);
                }
            }
        }

        return Optional.empty();
    }
}
