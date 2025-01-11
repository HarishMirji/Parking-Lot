package java.com.scaler.machinecoding.controllers;

import java.com.scaler.machinecoding.dtos.GenerateTicketRequestDto;
import java.com.scaler.machinecoding.dtos.GenerateTicketResponseDto;
import java.com.scaler.machinecoding.dtos.ResponseStatus;
import java.com.scaler.machinecoding.models.Ticket;
import java.com.scaler.machinecoding.models.VehicleType;
import java.com.scaler.machinecoding.service.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    public Ticket generateTicket(Vehicle vehicle, Gate gate) {
//
//    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
        String vehicleNumber = requestDto.getVehicleNumber();
        VehicleType vehicleType = requestDto.getVehicleType();
        Long gateId = requestDto.getGateId();

        Ticket ticket = ticketService.generateTicket(gateId, vehicleType, vehicleNumber);

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        responseDto .setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setTicketId(ticket.getId());
        responseDto.setOperatorName(ticket.getOperator().getName());
        responseDto.setSpotNumber(ticket.getParkingSpot().getNumber());

        return responseDto;
    }
}
