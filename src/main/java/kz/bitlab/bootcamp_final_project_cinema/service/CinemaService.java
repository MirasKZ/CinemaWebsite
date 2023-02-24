package kz.bitlab.bootcamp_final_project_cinema.service;


import kz.bitlab.bootcamp_final_project_cinema.model.Cinema;
import kz.bitlab.bootcamp_final_project_cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getCinemas(){
        return cinemaRepository.findAll();
    }


}
