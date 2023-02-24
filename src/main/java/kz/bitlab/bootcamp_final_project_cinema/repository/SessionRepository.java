package kz.bitlab.bootcamp_final_project_cinema.repository;

import kz.bitlab.bootcamp_final_project_cinema.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional

public interface SessionRepository extends JpaRepository<Session,Long> {

    public List<Session> findByFilm_IdOrderByLocalDateTimeAsc(Long id);

}
