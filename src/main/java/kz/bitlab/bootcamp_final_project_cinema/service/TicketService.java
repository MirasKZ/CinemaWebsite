package kz.bitlab.bootcamp_final_project_cinema.service;

import kz.bitlab.bootcamp_final_project_cinema.model.Session;
import kz.bitlab.bootcamp_final_project_cinema.model.Ticket;
import kz.bitlab.bootcamp_final_project_cinema.model.User;
import kz.bitlab.bootcamp_final_project_cinema.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private SessionService sessionService;

    public Ticket addTicket(Long session_id, int row_number, int col_number, int price_number, Long user_id){
        Ticket ticket = new Ticket();
        Session newSession = new Session();
        newSession.setId(session_id);
        ticket.setSession(newSession);
        ticket.setSeatNumber(getSeat(row_number,col_number));
        User newUser = new User();
        newUser.setId(user_id);
        ticket.setUser(newUser);
        Session session = sessionService.getSession(session_id);
        if(price_number==1){
            ticket.setPrice(session.getAdultPrice());
            ticket.setType("Взрослый");
        }
        else if(price_number==2){
            ticket.setPrice(session.getStudentPrice());
            ticket.setType("Студенческий");
        }
        else{
            ticket.setPrice(session.getStudentPrice());
            ticket.setType("Детский");
        }
        return ticketRepository.save(ticket);
    }


    public List<Ticket> getTicketsByUserId(Long user_id){
        return ticketRepository.findAllByUserId(user_id);
    }

    public List<Ticket> getTicketsBySession(Session session){
        return ticketRepository.findAllBySession(session);
    }

    private int getSeat(int row, int col){
        return (row-1)*5+col;
    }
}
