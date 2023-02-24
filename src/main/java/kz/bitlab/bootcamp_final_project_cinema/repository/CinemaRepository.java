package kz.bitlab.bootcamp_final_project_cinema.repository;

import kz.bitlab.bootcamp_final_project_cinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
