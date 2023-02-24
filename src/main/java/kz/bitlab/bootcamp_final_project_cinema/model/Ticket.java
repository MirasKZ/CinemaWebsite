package kz.bitlab.bootcamp_final_project_cinema.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_tickets")
@Getter
@Setter

public class Ticket extends BaseModel{

    @ManyToOne
    public Session session;
    @ManyToOne
    public User user;
    public int seatNumber;
    public int price;
    public String type;

}
