package com.glearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
