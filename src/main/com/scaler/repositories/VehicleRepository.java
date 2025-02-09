package main.com.scaler.repositories;

import main.com.scaler.models.Vehicle;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {

    private Map<Long, Vehicle> vehiclesById = new TreeMap<>();
    private Map<String, Vehicle> vehiclesByNumber = new TreeMap<>();

    private long lastSavedId = 0L;

    public Optional<Vehicle> findByVehicleNumber(String number) {
        if(vehiclesByNumber.containsKey(number)){
            return Optional.of(vehiclesByNumber.get(number));
        }

        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        lastSavedId += 1;
        vehicle.setId(lastSavedId);
        vehiclesById.put(lastSavedId, vehicle);
        return vehicle;
    }
}
