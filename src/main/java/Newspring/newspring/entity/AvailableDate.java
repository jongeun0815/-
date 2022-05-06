package Newspring.newspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import Newspring.newspring.exception.table.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "available_date")
@Getter
public class AvailableDate {

    @Id
    @GeneratedValue
    @Column(name = "available_data_id")
    private Long id;

    @Column(nullable = false)
    private String date;

    // 양방향
    @OneToMany(mappedBy = "availableDate", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"availableDate"})
    private List<AvailableTime> availableTimes = new ArrayList<>();


    @Type(type = "yes_no")
    private Boolean enabled = true;

    public void setEnabled(boolean flag) {
        this.enabled = flag;
    }

    @Builder(builderMethodName = "createAvailableDate")
    public AvailableDate(String date){
        this.date=date;
    }

}