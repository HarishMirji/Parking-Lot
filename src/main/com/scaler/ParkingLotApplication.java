package main.com.scaler;

import main.com.scaler.controllers.TicketController;
import main.com.scaler.repositories.GateRepository;
import main.com.scaler.repositories.ParkingLotRepository;
import main.com.scaler.repositories.TicketRepository;
import main.com.scaler.repositories.VehicleRepository;
import main.com.scaler.service.TicketService;
import main.com.scaler.strategies.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import main.com.scaler.strategies.spotassignmentstrategy.SpotAssignmentStrategy;

public class ParkingLotApplication {

    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                spotAssignmentStrategy,
                ticketRepository,
                parkingLotRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application has started on port :8080");
    }
}
