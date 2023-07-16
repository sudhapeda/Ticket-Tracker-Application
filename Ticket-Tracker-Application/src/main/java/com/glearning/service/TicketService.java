package com.glearning.service;

import java.util.List;
import java.util.Optional;

import com.glearning.model.Ticket;

public interface TicketService {
    List<Ticket> getAllTickets();

    Optional<Ticket> getTicketById(Long id);

    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(Ticket ticket);

    void deleteTicket(Long id);
}
