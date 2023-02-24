package kz.bitlab.bootcamp_final_project_cinema.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "t_PERMISSIONS")
@Getter
@Setter

public class Permission extends BaseModel implements GrantedAuthority {

    public String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
