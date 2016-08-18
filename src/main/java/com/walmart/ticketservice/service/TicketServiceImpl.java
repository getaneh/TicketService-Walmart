/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walmart.ticketservice.service;

import com.walmart.ticketservice.data.Seat;
import java.util.Optional;
import java.util.stream.Collectors;
import com.walmart.ticketservice.data.SeatHold;
import com.walmart.ticketservice.data.SeatHoldImpl;
import com.walmart.ticketservice.data.TicketServiceManager;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Getaneh Kassahun
 */
public class TicketServiceImpl implements TicketService {

    @Override
    public int numSeatsAvailable(Optional<Integer> venueLevel) {
        return (int) TicketServiceManager.getInstance().getAllSeats().stream()
                .filter(s -> (!venueLevel.isPresent() || s.getLevelId() == venueLevel.get()) && s.isAvailable()).count();
    }

    @Override
    public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel, String customerEmail) {
        List<Seat> seats = TicketServiceManager.getInstance().getAllSeats().stream()
                .filter(s -> s.isAvailable()
                        && (!minLevel.isPresent() || s.getLevelId() >= minLevel.get())
                        && (!maxLevel.isPresent() || s.getLevelId() <= maxLevel.get())
                )
                .sorted(Comparator.comparing(s -> s.getLevelId()))
                .limit(numSeats)
                .collect(Collectors.toList());

        SeatHold seatHold = new SeatHoldImpl(customerEmail);
        seatHold.addSeats(seats);
        TicketServiceManager.getInstance().addSeatHold(seatHold);

        return seatHold;
    }

    @Override
    public String reserveSeats(int seatHoldId, String customerEmail) {
        SeatHold seatHold = TicketServiceManager.getInstance().getSeatHold(seatHoldId);
        seatHold.reserve();
        return seatHold.getResearvationCode();
    }

}
