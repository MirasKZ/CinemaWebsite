package kz.bitlab.bootcamp_final_project_cinema.repository;


import kz.bitlab.bootcamp_final_project_cinema.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film, Long> {

//    public Film findById(Long id);

}
