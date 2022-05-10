package Newspring.newspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "admin")
@Getter
public class Admin extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"admin"})
    private Restaurant restaurant = new Restaurant();

    @Builder(builderMethodName = "createAdmin")
    public Admin(String name) {
        this.name = name;
    }
}