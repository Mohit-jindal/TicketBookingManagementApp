package com.infotech.book.ticket.app.controller;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.book.ticket.app.entities.Ticket;
import com.infotech.book.ticket.app.service.TicketBookingService;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController 
{

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@PostMapping(value = "/create")
	public Ticket createTicket(@RequestBody Ticket ticket)
	{
		return ticketBookingService.createTicket(ticket);
	}
	
	@GetMapping(value = "/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable Integer ticketId)
	{
		return ticketBookingService.getTicketById(ticketId);
	}
	
	@GetMapping(value = "/ticket/alltickets")
	public Iterable<Ticket> getAllBookedTickets()
	{
		return ticketBookingService.getAllBookedTickets();
	}
	
	@DeleteMapping(value = "/ticket/{ticketId}")
	public void deleteTicket(@PathVariable Integer ticketId)
	{
		ticketBookingService.deleteTicket(ticketId);
	}
	
	@PutMapping(value = "/ticket/{ticketId}/{newEmail:.+}") //here :.+ is regex to save .com because MVC framework ignore after . symbol and gusess that is a file extension
	public Ticket updateTicket(@PathVariable Integer ticketId, @PathVariable String newEmail, @RequestBody Ticket ticket)
	{
		return ticketBookingService.updateTicket(ticketId,newEmail);
	}
}
