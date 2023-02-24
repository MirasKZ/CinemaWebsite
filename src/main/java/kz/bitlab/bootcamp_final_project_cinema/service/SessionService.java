package kz.bitlab.bootcamp_final_project_cinema.service;


import kz.bitlab.bootcamp_final_project_cinema.model.Cinema;
import kz.bitlab.bootcamp_final_project_cinema.model.Film;
import kz.bitlab.bootcamp_final_project_cinema.model.Session;
import kz.bitlab.bootcamp_final_project_cinema.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;


    public List<Session> getSessionsByFilm(Long id){
        return sessionRepository.findByFilm_IdOrderByLocalDateTimeAsc(id);
    }

    public Session addSession(Long film_id, Long cinema_id, LocalDateTime datetime,
                              int adultPrice, int studentPrice, int childPrice){
        Session ses = new Session();
        Film f = new Film();
        f.setId(film_id);
        ses.setFilm(f);
        Cinema cin = new Cinema();
        cin.setId(cinema_id);
        ses.setCinema(cin);
        ses.setLocalDateTime(datetime);
        ses.setAdultPrice(adultPrice);
        ses.setStudentPrice(studentPrice);
        ses.setChildPrice(childPrice);
        return sessionRepository.save(ses);
    }

    public Session getSession(Long id){
        return sessionRepository.findById(id).orElseThrow();
    }





}
