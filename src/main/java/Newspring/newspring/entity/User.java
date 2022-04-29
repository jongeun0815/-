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
    private int id;
    private String email;
    private String password;
    private String role;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}