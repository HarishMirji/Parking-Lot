package java.com.scaler.machinecoding.dtos;

import java.com.scaler.machinecoding.models.VehicleType;

public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long gateId;

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
