/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.presentation;

import com.walmart.ticketservice.data.SeatHold;
import com.walmart.ticketservice.service.TicketService;
import com.walmart.ticketservice.service.TicketServiceImpl;
import java.util.Optional;

/**
 *
 * @author Getaneh Kassahun
 */
public class TicketServiceMain {

    public static void main(String[] args) {
        TicketService ticketService = new TicketServiceImpl();

    //Availble
        System.out.println("Initial total available seats for each level");
        //Orchestra -
        System.out.println("Level 1 seat : " + ticketService.numSeatsAvailable(Optional.of(1)));
        //Main
        System.out.println("Level 2 seat : " + ticketService.numSeatsAvailable(Optional.of(2)));
        //Balcony 1
        System.out.println("Level 3 seat : " + ticketService.numSeatsAvailable(Optional.of(3)));
        //Balcony 2
        System.out.println("Level 4 seat : " + ticketService.numSeatsAvailable(Optional.of(4)));

    //Hold
        SeatHold seatHold1 = ticketService.findAndHoldSeats(100, Optional.of(1), Optional.of(1), "getanehka@gmail.com");
        SeatHold seatHold2 = ticketService.findAndHoldSeats(100, Optional.of(2), Optional.of(2), "getanehka@gmail.com");
        SeatHold seatHold3 = ticketService.findAndHoldSeats(100, Optional.of(3), Optional.of(3), "getanehka@gmail.com");
        SeatHold seatHold4 = ticketService.findAndHoldSeats(100, Optional.of(4), Optional.of(4), "getanehka@gmail.com");

        System.out.println("Total available seats for each level after hold");
        //Orchestra -
        System.out.println("Level 1 seat : " + ticketService.numSeatsAvailable(Optional.of(1)));
        //Main
        System.out.println("Level 2 seat : " + ticketService.numSeatsAvailable(Optional.of(2)));
        //Balcony 1
        System.out.println("Level 3 seat : " + ticketService.numSeatsAvailable(Optional.of(3)));
        //Balcony 2
        System.out.println("Level 4 seat : " + ticketService.numSeatsAvailable(Optional.of(4)));

    //Reserve
        ticketService.reserveSeats(seatHold1.getSeatHoldId(), "getanehka@gmail.com");
        ticketService.reserveSeats(seatHold2.getSeatHoldId(), "getanehka@gmail.com");
        ticketService.reserveSeats(seatHold3.getSeatHoldId(), "getanehka@gmail.com");
        ticketService.reserveSeats(seatHold4.getSeatHoldId(), "getanehka@gmail.com");

        System.out.println("Total available seats for each level after reserve");
        //Orchestra -
        System.out.println("Level 1 seat : " + ticketService.numSeatsAvailable(Optional.of(1)));
        //Main
        System.out.println("Level 2 seat : " + ticketService.numSeatsAvailable(Optional.of(2)));
        //Balcony 1
        System.out.println("Level 3 seat : " + ticketService.numSeatsAvailable(Optional.of(3)));
        //Balcony 2
        System.out.println("Level 4 seat : " + ticketService.numSeatsAvailable(Optional.of(4)));
    }
}
