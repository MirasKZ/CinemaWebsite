package kz.bitlab.bootcamp_final_project_cinema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_cinemas")
@Getter
@Setter
public class Cinema extends BaseModel{

    private String name;

}
