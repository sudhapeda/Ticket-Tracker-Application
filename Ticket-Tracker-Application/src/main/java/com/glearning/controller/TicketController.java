package com.glearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.glearning.model.Ticket;
import com.glearning.service.TicketService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String getAllTickets(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm() {
        return "create";
    }

    @PostMapping("/create")
    public String createTicket(@ModelAttribute Ticket ticket) {
        ticketService.createTicket(ticket);
        System.out.println(ticket.getId());
        return "redirect:/tickets/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        if (ticket.isPresent()) {
            model.addAttribute("ticket", ticket.get());
            return "edit";
        } else {
            return "redirect:/tickets/";
        }
    }

    @PostMapping("/update")
    public String updateTicket(@ModelAttribute Ticket ticket) {
        ticketService.updateTicket(ticket);
        return "redirect:/tickets/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return "redirect:/tickets/";
    }

    @GetMapping("/view/{id}")
    public String viewTicket(@PathVariable Long id, Model model) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        if (ticket.isPresent()) {
            model.addAttribute("ticket", ticket.get());
            return "view";
        } else {
            return "redirect:/tickets/";
        }
    }
}
