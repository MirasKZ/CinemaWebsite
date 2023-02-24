package kz.bitlab.bootcamp_final_project_cinema.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_FILMS")
@Getter
@Setter


public class Film extends BaseModel{

    public String name;

    @Column(columnDefinition = "TEXT")
    public String description;

    public String imgUrl;

}
