package kz.bitlab.bootcamp_final_project_cinema.repository;

import kz.bitlab.bootcamp_final_project_cinema.model.Session;
import kz.bitlab.bootcamp_final_project_cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByUserId(Long id);
    List<Ticket> findAllBySession(Session session);
}
