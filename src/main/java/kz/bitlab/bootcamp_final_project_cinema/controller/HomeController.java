package kz.bitlab.bootcamp_final_project_cinema.controller;


import kz.bitlab.bootcamp_final_project_cinema.model.*;
import kz.bitlab.bootcamp_final_project_cinema.service.CinemaService;
import kz.bitlab.bootcamp_final_project_cinema.service.FilmService;
import kz.bitlab.bootcamp_final_project_cinema.service.SessionService;
import kz.bitlab.bootcamp_final_project_cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private FilmService filmService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        return "index";
    }


    @GetMapping(value = "/signin")
    public String signIn() {
        return "signin";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile() {
        //po user id beru vse bilety

        return "profile";
    }


    @GetMapping(value = "/details/{id}")
    public String filmTickets(@PathVariable Long id,Model model) {
        Film film = filmService.getById(id);
        model.addAttribute("film", film);
        List<Session> sessions = sessionService.getSessionsByFilm(id);
        model.addAttribute("sessions", sessions);
        List<Cinema> cinemas= cinemaService.getCinemas();
        model.addAttribute("cinemas", cinemas);
        return "details";
    }


    @GetMapping(value = "/films")
    public String getFilms(Model model) {
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        return "films";
    }

    @PostMapping(value = "/addsession")
    public String addSession(@RequestParam Long film_id, @RequestParam Long cinema_id,
                             @RequestParam LocalDateTime datetime, @RequestParam int adult_price,
                             @RequestParam int student_price, @RequestParam int child_price){
        Session session =sessionService.addSession(film_id, cinema_id, datetime, adult_price, student_price, child_price);
        if(session==null){
            return "redirect:/details/"+film_id+"/error";
        }
        return "redirect:/details/"+film_id;
    }



    @GetMapping(value = "seansy/{id}")
    public String seansDetails(Model model, @PathVariable Long id){
        Session  newSes = sessionService.getSession(id);
        model.addAttribute("ses",newSes);
        List<Ticket> tickets = ticketService.getTicketsBySession(newSes);
        model.addAttribute("tickets",tickets);
        return "seans";
    }

    @PostMapping(value = "/buyTicket")
    public String buyTicket(@RequestParam Long session_id, @RequestParam int row_number,
                            @RequestParam int col_number, @RequestParam int price_number,@RequestParam Long user_id){
        ticketService.addTicket(session_id, row_number, col_number, price_number, user_id);
        return "redirect:/seansy/"+session_id;
    }

}
