package main.com.scaler.repositories;

import main.com.scaler.models.Gate;
import main.com.scaler.models.ParkingLot;
import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();

    public ParkingLot getParkingLotOfGate(Gate gate) {
        for(ParkingLot parkingLot : parkingLots.values()){
            if(parkingLot.getGates().contains(gate)){
                return parkingLot;
            }
        }
        return null;
    }
}
