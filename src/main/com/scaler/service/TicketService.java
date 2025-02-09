package main.com.scaler.service;

import main.com.scaler.exceptions.InvalidGateException;
import main.com.scaler.exceptions.NoAvailableSpotException;
import main.com.scaler.models.*;
import main.com.scaler.repositories.GateRepository;
import main.com.scaler.repositories.ParkingLotRepository;
import main.com.scaler.repositories.TicketRepository;
import main.com.scaler.repositories.VehicleRepository;
import main.com.scaler.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

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

    public Ticket generateTicket(Long gateID, VehicleType vehicleType, String vehicleNumber) throws InvalidGateException, NoAvailableSpotException {
        /*
        Gate -> get gate gor that from DB, else throw an exception
        Operator -> from gate
        Vehicle -> check if it is already in the DB, else create
        ParkingSpot ->  strategy
        Ticket ticket ->
        */
        Optional<Gate> optionalGate = gateRepository.findGateByID(gateID);

        if (optionalGate.isEmpty()) {
            throw new InvalidGateException("Invalid gateId has given");
        }

        Gate gate = optionalGate.get();

        Operator operator = gate.getOperator();

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle;
        if (optionalVehicle.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);  // It is better to have this implementation in Vehicle service
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
        } else {
            vehicle = optionalVehicle.get();
        }
        ParkingLot parkingLot = parkingLotRepository.getParkingLotOfGate(gate);

        Optional<Spot> optionalSpot = spotAssignmentStrategy.findSpot(vehicleType, parkingLot, gate);

        if (optionalSpot.isEmpty()) {
            throw new NoAvailableSpotException("No Spot will be available.");
        }

        Spot spot = optionalSpot.get();

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
