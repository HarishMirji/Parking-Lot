package java.com.scaler.machinecoding.service;

import java.com.scaler.machinecoding.exceptions.InvalidGateException;
import java.com.scaler.machinecoding.models.*;
import java.com.scaler.machinecoding.repositories.GateRepository;
import java.com.scaler.machinecoding.repositories.ParkingLotRepository;
import java.com.scaler.machinecoding.repositories.TicketRepository;
import java.com.scaler.machinecoding.repositories.VehicleRepository;
import java.com.scaler.machinecoding.strategies.spotassignmentstrategy.SpotAssignmentStrategy;
import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         TicketRepository ticketRepository,
                         ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(Long gateID, VehicleType vehicleType, String vehicleNumber) throws InvalidGateException {
        /*
        Gate -> get gate gor that from DB, else throw exception
        Operator -> from gate
        Vehicle -> check if it is already in the DB, else create
        ParkingSpot ->  strategy
        Ticket ticket ->
        */
        Optional<Gate> optionalGate = gateRepository.findGateByID(gateID);

        if(optionalGate.isEmpty()){
            throw new InvalidGateException("Invalid gateId has goven");
        }

        Gate gate = optionalGate.get();

        Operator operator = gate.getOperator();

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle;
        if(optionalVehicle.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);  // It is better to have this implementation in Vehicle service
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
        }else{
            vehicle = optionalVehicle.get();
        }
        ParkingLot parkingLot = parkingLotRepository.getParkingLotOfGate(gate);

        Spot spot = spotAssignmentStrategy.findSpot(vehicleType, parkingLot, gate);

        Ticket ticket = new Ticket();
        ticket.setParkingSpot(spot);
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setOperator(operator);
        ticket.setEntryTime(new Date());

        return ticketRepository.save(ticket);
    }

//    public Ticket generateTicket(Long gateID, VehicleType type, String vehicleNumber){
//        GenerateTicketArgumentsBuilder arguments // if and only if a lot of parameters
//    }

}
