package main.com.scaler.repositories;

import main.com.scaler.models.Gate;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/*Have every method allows to do CRUD onoperations on gate on DB  */
public class GateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();

    public Optional<Gate> findGateByID(Long gateId) {
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }
}
