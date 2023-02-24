package kz.bitlab.bootcamp_final_project_cinema.api;


import jakarta.persistence.Access;
import kz.bitlab.bootcamp_final_project_cinema.model.Session;
import kz.bitlab.bootcamp_final_project_cinema.model.Ticket;
import kz.bitlab.bootcamp_final_project_cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TicketsController {

    @Autowired
    private TicketService ticketService;
    @GetMapping(value = "/tickets/{id}")
    public List<Ticket> getTickets(@PathVariable Session id){
        return ticketService.getTicketsBySession(id);
    }

}
