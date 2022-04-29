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
    private String id;
    private String email;
    private String password;
    private String role;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}