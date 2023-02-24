package kz.bitlab.bootcamp_final_project_cinema.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_sessions")
@Getter
@Setter
public class Session extends BaseModel{
    @ManyToOne(fetch = FetchType.EAGER)
    public Film film;
    public LocalDateTime localDateTime;
    @ManyToOne
    public Cinema cinema;
    public int adultPrice;
    public int studentPrice;
    public int childPrice;


}
