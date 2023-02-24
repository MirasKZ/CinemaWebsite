package kz.bitlab.bootcamp_final_project_cinema.service;

import kz.bitlab.bootcamp_final_project_cinema.model.Film;
import kz.bitlab.bootcamp_final_project_cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public Film getById(Long id){
        return filmRepository.findById(id).orElseThrow();
    }

}
