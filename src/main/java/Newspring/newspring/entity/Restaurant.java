package Newspring.newspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import Newspring.newspring.exception.table.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "restaurant")
@Getter
public class Restaurant extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "rastaurant_id")
    private Long id;

    // 양방향
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"restaurant"})
    private List<AvailableDate> availableDates = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;
    /*
    public void setAdmin(Admin admin) {
        this.admin = admin;
        admin.getRestaurant().add(this);
    }
    */

    @Column(name = "total_table")
    private Integer totalTable = 12;
    public void cancel() {
        this.totalTable++;
    }

    @Column(name = "date_accept")
    private Integer dateAccept;

    @Column(name = "time_accept")
    private Integer timeAccept;

    public void removeTableStock() {
        int restTableStock=this.totalTable-1;
        if(restTableStock==0){
            setEnabled(false);
        }
        if(restTableStock<0){
            throw new NotEnoughStockException("예약 가능한 테이블이 없습니다.");
        }

        this.totalTable=restTableStock;
    }

    public void updateDateAccept(Integer dateAccept){this.dateAccept=dateAccept;}

    public void updateTimeAccept(Integer timeAccept){this.timeAccept=timeAccept;}

    // true: y, false: n
    @Type(type = "yes_no")
    private Boolean enabled = true; // 예약 가능 여부

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonIgnoreProperties({"restaurant"})
    private List<HasTable> hastables = new ArrayList<>();

    public void setEnabled(boolean flag) {
        this.enabled = flag;
    }
    /*
    // 연관관계 편의 메서드
    private void addAdmin(Admin admin) {
        this.admin = admin;
        admin.getRestaurant().add(this);
    }
    */


    @Builder(builderMethodName = "createBIPS")
    public Restaurant(Integer dateAccept,Integer timeAccept) {
        this.createAt = LocalDateTime.now();
        this.dateAccept=dateAccept;
        this.timeAccept=timeAccept;
    }
}