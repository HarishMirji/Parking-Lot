package main.com.scaler.controllers;

import main.com.scaler.dtos.GenerateTicketRequestDto;
import main.com.scaler.dtos.GenerateTicketResponseDto;
import main.com.scaler.dtos.ResponseStatus;
import main.com.scaler.exceptions.InvalidGateException;
import main.com.scaler.exceptions.NoAvailableSpotException;
import main.com.scaler.models.Ticket;
import main.com.scaler.models.VehicleType;
import main.com.scaler.service.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    public Ticket generateTicket(Vehicle vehicle, Gate gate) {
//
//    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) throws InvalidGateException, NoAvailableSpotException {
        String vehicleNumber = requestDto.getVehicleNumber();
        VehicleType vehicleType = requestDto.getVehicleType();
        Long gateId = requestDto.getGateId();

        Ticket ticket = new Ticket();
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try {
            ticket = ticketService.generateTicket(gateId, vehicleType, vehicleNumber);
        } catch (InvalidGateException e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage("Gate Id is invalid");
            return responseDto;
        } catch (NoAvailableSpotException e) {
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("No parking spot available");
            return responseDto;
        }


        responseDto .setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setTicketId(ticket.getId());
        responseDto.setOperatorName(ticket.getOperator().getName());
        responseDto.setSpotNumber(ticket.getParkingSpot().getNumber());

        return responseDto;
    }
}
