package Newspring.newspring.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
@Getter
@Setter
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String role;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}